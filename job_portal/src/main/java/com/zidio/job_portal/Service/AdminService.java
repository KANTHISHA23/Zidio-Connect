package com.zidio.job_portal.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zidio.job_portal.DTO.AdminDTO;
import com.zidio.job_portal.DTO.SystemStatusDTO;
import com.zidio.job_portal.DTO.UserStatusUpdateDTO;
import com.zidio.job_portal.Entity.Admin;
import com.zidio.job_portal.Entity.User;
import com.zidio.job_portal.Enum.Role;
import com.zidio.job_portal.Repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // ✅ Create admin when a user with ADMIN role registers
    public void createAdminFromUser(User user) {
        Admin admin = new Admin();
        admin.setEmail(user.getEmail());
        admin.setRole(Role.ADMIN);
        admin.setActive(true);
        adminRepository.save(admin);
    }

    // ✅ Ensure admin exists at login
    public void ensureAdminExists(User user) {
        if (user.getRole() == Role.ADMIN && 
            adminRepository.findByEmail(user.getEmail()).isEmpty()) {
            createAdminFromUser(user);
        }
    }

    public List<AdminDTO> getAllUsers() {
        return adminRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<AdminDTO> getUserByRole(Role role) {
        return adminRepository.findByRole(role).stream().map(this::toDTO).collect(Collectors.toList());
    }

    public AdminDTO updateUserStatus(UserStatusUpdateDTO dto) {
        Optional<Admin> optional = adminRepository.findById(dto.getUserId());
        if (!optional.isPresent()) {
            throw new RuntimeException("user not found");
        }
        Admin user = optional.get();
        user.setActive(dto.active);
        adminRepository.save(user);

        return toDTO(user);
    }

    public SystemStatusDTO getSystemStatus() {
        int totalUsers = (int) adminRepository.count();
        int totalEmployees = (int) adminRepository.count();
        int totalRecruiters = (int) adminRepository.count();
        int totalJobPosts = (int) adminRepository.count();
        int totalApplications = (int) adminRepository.count();

        SystemStatusDTO status = new SystemStatusDTO();
        status.setTotalUsers(totalUsers);
        status.setTotalEmployee(totalEmployees);
        status.setTotalRecruiters(totalRecruiters);
        status.setTotalJobPosts(totalJobPosts);
        status.setTotalApplications(totalApplications);

        return status;
    }

    private AdminDTO toDTO(Admin admin) {
        AdminDTO dto = new AdminDTO();
        dto.setId(admin.getId());
        dto.setEmail(admin.getEmail());
        dto.setRole(admin.getRole());
        dto.setActive(admin.isActive());

        return dto;
    }
    
    public long countAdmins() {
        return adminRepository.count();
    }

}
