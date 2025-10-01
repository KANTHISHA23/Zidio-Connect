package com.zidio.job_portal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zidio.job_portal.DTO.AuthResponse;
import com.zidio.job_portal.DTO.LoginRequest;
import com.zidio.job_portal.DTO.RegisterRequest;
import com.zidio.job_portal.Entity.User;
import com.zidio.job_portal.Enum.Role;
import com.zidio.job_portal.Repository.UserRepository;
import com.zidio.job_portal.Security.JWTUtil;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final JWTUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final AdminService adminService;

    @Autowired
    public AuthService(UserRepository userRepository,
                       JWTUtil jwtUtil,
                       PasswordEncoder passwordEncoder,
                       AdminService adminService) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
        this.adminService = adminService;
    }

    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.email)) {
            throw new RuntimeException("Email already registered!");
        }

        User user = new User();
        user.setName(request.name);
        user.setEmail(request.email);
        user.setPassword(passwordEncoder.encode(request.password));
        user.setRole(request.role);
        userRepository.save(user);

        // ✅ Delegate admin creation to AdminService
        if (request.role == Role.ADMIN) {
            adminService.createAdminFromUser(user);
        }

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());
        return new AuthResponse(token, user.getRole(), user.getName(), "User registered successfully!");
    }

    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        // ✅ Ensure admin record exists in admins table
        if (user.getRole() == Role.ADMIN) {
            adminService.ensureAdminExists(user);
        }

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());
        return new AuthResponse(token, user.getRole(), user.getName(), "User logged in successfully!");
    }
}
