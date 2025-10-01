package com.zidio.job_portal.DTO;

import com.zidio.job_portal.Enum.ApplicationStatus;

public class UpdateApplicationStatusDTO {

    private Long id;   // match entity & DB
    private ApplicationStatus status;

    public UpdateApplicationStatusDTO() {}

    public UpdateApplicationStatusDTO(Long id, ApplicationStatus status) {
        this.id = id;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public ApplicationStatus getStatus() { return status; }
    public void setStatus(ApplicationStatus status) { this.status = status; }
}
