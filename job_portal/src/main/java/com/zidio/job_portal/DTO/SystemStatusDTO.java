package com.zidio.job_portal.DTO;

public class SystemStatusDTO {

	public int totalUsers;
	public int totalRecruiters;
	public int totalEmployee;
	public int totalJobPosts;
	public int totalApplications;
	
	public SystemStatusDTO() {}
	
	public SystemStatusDTO(int totalUsers, int totalRecruiters, int totalEmployee, int totalJobPosts, int totalApplications) {
		
		this.totalUsers=totalUsers;
		this.totalRecruiters=totalRecruiters;
		this.totalEmployee=totalEmployee;
		this.totalJobPosts=totalJobPosts;
		this.totalApplications=totalApplications;
	}

	public int getTotalUsers() {
		return totalUsers;
	}

	public void setTotalUsers(int totalUsers) {
		this.totalUsers = totalUsers;
	}

	public int getTotalRecruiters() {
		return totalRecruiters;
	}

	public void setTotalRecruiters(int totalRecruiters) {
		this.totalRecruiters = totalRecruiters;
	}

	public int getTotalEmployee() {
		return totalEmployee;
	}

	public void setTotalEmployee(int totalEmployee) {
		this.totalEmployee = totalEmployee;
	}

	public int getTotalJobPosts() {
		return totalJobPosts;
	}

	public void setTotalJobPosts(int totalJobPosts) {
		this.totalJobPosts = totalJobPosts;
	}

	public int getTotalApplications() {
		return totalApplications;
	}

	public void setTotalApplications(int totalApplications) {
		this.totalApplications = totalApplications;
	}
	
	
}
