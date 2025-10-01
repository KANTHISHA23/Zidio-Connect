package com.zidio.job_portal.DTO;

import com.zidio.job_portal.Enum.ApplicationStatus;

public class ApplicationStatusUpdate {

	public Long applicationId;
	public ApplicationStatus status;
	
	public ApplicationStatusUpdate() {}

	public ApplicationStatusUpdate(Long applicationId, ApplicationStatus status) {
		this.applicationId=applicationId;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public ApplicationStatus getStatus() {
		return status;
	}

	public void setStatus(ApplicationStatus status) {
		this.status = status;
	}
	
	
}
