package com.zidio.job_portal.DTO;

public class DashBoardDTO {
 
    private long totalEmployees;
    private long totalRecruiters;
    private long totalJobs;
    private long totalApplications;
    private long totalAdmins;
    private long totalPayments;

    // Getters & Setters
    public long getTotalEmployees() {
        return totalEmployees;
    }
    public void setTotalEmployees(long totalEmployees) {
        this.totalEmployees = totalEmployees;
    }
    public long getTotalRecruiters() {
        return totalRecruiters;
    }
    public void setTotalRecruiters(long totalRecruiters) {
        this.totalRecruiters = totalRecruiters;
    }
    public long getTotalJobs() {
        return totalJobs;
    }
    public void setTotalJobs(long totalJobs) {
        this.totalJobs = totalJobs;
    }
    public long getTotalApplications() {
        return totalApplications;
    }
    public void setTotalApplications(long totalApplications) {
        this.totalApplications = totalApplications;
    }
    public long getTotalAdmins() {
        return totalAdmins;
    }
    public void setTotalAdmins(long totalAdmins) {
        this.totalAdmins = totalAdmins;
    }
    public long getTotalPayments() {
        return totalPayments;
    }
    public void setTotalPayments(long totalPayments) {
        this.totalPayments = totalPayments;
    }
}
