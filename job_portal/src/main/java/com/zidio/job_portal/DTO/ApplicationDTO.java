package com.zidio.job_portal.DTO;

import com.zidio.job_portal.Enum.ApplicationStatus;

public class ApplicationDTO {

    private Long id;   // keep it consistent with DB column name
    private Long jobId;
    private String employeeEmail;
    private String recruiterEmail;
    private ApplicationStatus status;
    private String resumeURL;

    public ApplicationDTO() {}

    public ApplicationDTO(Long id, Long jobId, String employeeEmail, 
                          ApplicationStatus status, String recruiterEmail, String resumeURL) {
        this.id = id;
        this.jobId = jobId;
        this.employeeEmail = employeeEmail;
        this.recruiterEmail = recruiterEmail;
        this.status = status;
        this.resumeURL = resumeURL;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getJobId() { return jobId; }
    public void setJobId(Long jobId) { this.jobId = jobId; }

    public String getEmployeeEmail() { return employeeEmail; }
    public void setEmployeeEmail(String employeeEmail) { this.employeeEmail = employeeEmail; }

    public String getRecruiterEmail() { return recruiterEmail; }
    public void setRecruiterEmail(String recruiterEmail) { this.recruiterEmail = recruiterEmail; }

    public ApplicationStatus getStatus() { return status; }
    public void setStatus(ApplicationStatus status) { this.status = status; }

    public String getResumeURL() { return resumeURL; }
    public void setResumeURL(String resumeURL) { this.resumeURL = resumeURL; }
}
