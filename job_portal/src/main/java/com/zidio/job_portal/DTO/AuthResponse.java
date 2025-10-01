package com.zidio.job_portal.DTO;

import com.zidio.job_portal.Enum.Role;

public class AuthResponse {
  
	public String token;
    public Role role;
    public String name;
    public String message;
    
    public AuthResponse(String token, Role role, String name, String message) {
    	this.token=token;
    	this.role=role;
    	this.name=name;
    	this.message=message;
    }

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
    
}
