package com.zidio.job_portal.DTO;

public class RecruiterDTO {
   
	public Long id;
	public String recruiterName;
	public String companyName;
	public String recruiterEmail;
	public String recruiterPhone;
	public String designation;
	
	public RecruiterDTO() {}
	public RecruiterDTO(Long id, String recruiterName, String companyName, String recruiterEmail, String recruiterPhone,String designation) {
		this.id=id;
		this.companyName=companyName;
		this.recruiterName=recruiterName;
		this.recruiterPhone=recruiterPhone;
		this.recruiterEmail=recruiterEmail;
		this.designation=designation;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRecruiterName() {
		return recruiterName;
	}
	public void setRecruiterName(String recruiterName) {
		this.recruiterName = recruiterName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getRecruiterEmail() {
		return recruiterEmail;
	}
	public void setRecruiterEmail(String recruiterEmail) {
		this.recruiterEmail = recruiterEmail;
	}
	public String getRecruiterPhone() {
		return recruiterPhone;
	}
	public void setRecruiterPhone(String recruiterPhone) {
		this.recruiterPhone = recruiterPhone;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
}
