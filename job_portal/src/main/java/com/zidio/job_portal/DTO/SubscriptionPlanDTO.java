package com.zidio.job_portal.DTO;

public class SubscriptionPlanDTO {
  
	public Long id;
	public String name;
	
	public int maxJob;
	public int maxProfiles;
	public int validityDays;
	public double prices;
	
	public SubscriptionPlanDTO() {}
	public SubscriptionPlanDTO(Long id, String name, int maxJob, int maxProfiles, int validityDays, double prices) {
		this.id=id;
		this.name=name;
		this.maxJob=maxJob;
		this.maxProfiles=maxProfiles;
		this.validityDays=validityDays;
		this.prices=prices;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxJob() {
		return maxJob;
	}
	public void setMaxJob(int maxJob) {
		this.maxJob = maxJob;
	}
	public int getMaxProfiles() {
		return maxProfiles;
	}
	public void setMaxProfiles(int maxProfiles) {
		this.maxProfiles = maxProfiles;
	}
	public int getValidityDays() {
		return validityDays;
	}
	public void setValidityDays(int validityDays) {
		this.validityDays = validityDays;
	}
	public double getPrices() {
		return prices;
	}
	public void setPrices(double prices) {
		this.prices = prices;
	}

    
}
