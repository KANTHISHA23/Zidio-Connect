package com.zidio.job_portal.DTO;

import com.zidio.job_portal.Enum.ApplicationStatus;

public class ApplicationResponseDTO {

	public Long id;
	public Long jobId;
	public String employeeEmail;
	public ApplicationStatus status;
	
	public ApplicationResponseDTO() {}
	
	public ApplicationResponseDTO(Long id, Long jobId, String employeeEmail, ApplicationStatus status) {
		this.id=id;
		this.jobId=jobId;
		this.status=status;
		this.employeeEmail=employeeEmail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public ApplicationStatus getStatus() {
		return status;
	}

	public void setStatus(ApplicationStatus status) {
		this.status = status;
	}
	
	
}
