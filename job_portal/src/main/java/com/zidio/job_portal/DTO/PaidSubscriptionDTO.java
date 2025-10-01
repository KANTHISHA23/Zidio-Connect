package com.zidio.job_portal.DTO;

import java.time.LocalDate;

import com.zidio.job_portal.Enum.PaymentStatus;

public class PaidSubscriptionDTO {

	public Long recruiterId;
	public Long employeeId;
	public Long planId;
	
	public String userEmail;
    public Long id;
	public LocalDate startDate;
	public LocalDate endDate;
	public Double amount;
	public String currency;
	
	public PaymentStatus paymentStatus;
	public String invoiceUrl;
	
	public PaidSubscriptionDTO() {}
    public PaidSubscriptionDTO(Long id, Long recruiterId, Long employeeId, Long planId, LocalDate startDate, LocalDate endDate, String invoiceUrl, PaymentStatus paymenStatus,String userEmail, PaymentStatus paymentStatus, Double amount, String currency) {
        this.id=id;
        this.recruiterId=recruiterId;
        this.employeeId=employeeId;
        this.planId=planId;
        this.startDate=startDate;
        this.endDate=endDate;
        this.invoiceUrl=invoiceUrl;
        this.paymentStatus=paymentStatus;
        this.userEmail=userEmail;
        this.amount=amount;
        this.currency=currency;
    }
	public Long getRecruiterId() {
		return recruiterId;
	}
	public void setRecruiterId(Long recruiterId) {
		this.recruiterId = recruiterId;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public Long getPlanId() {
		return planId;
	}
	public void setPlanId(Long planId) {
		this.planId = planId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getInvoiceUrl() {
		return invoiceUrl;
	}
	public void setInvoiceUrl(String invoiceUrl) {
		this.invoiceUrl = invoiceUrl;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
    
}
