package com.zidio.job_portal.Entity;

import javax.persistence.*;

@Entity
@Table(name="recruiters")
public class Recruiter {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	private String recruiterName;
	private String companyName;
	private String recruiterEmail;
	private String recruiterPhone;
	private String designation;
	
	public Recruiter(){}
	public Recruiter(Long id, String recruiterName, String companyName, String recruiterEmail, String designation,String recruiterPhone) {
		this.id=id;
		this.recruiterName=recruiterName;
		this.companyName=companyName;
		this.recruiterEmail=recruiterEmail;
		this.designation=designation;
		this.recruiterPhone=recruiterPhone;
	}
	public String getRecruiterPhone() {
		return recruiterPhone;
	}
	public void setRecruiterPhone(String recruiterPhone) {
		this.recruiterPhone = recruiterPhone;
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
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
}
