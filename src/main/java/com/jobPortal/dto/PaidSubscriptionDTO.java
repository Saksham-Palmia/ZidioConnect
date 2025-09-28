package com.jobPortal.dto;

import java.time.LocalDate;

import com.jobPortal.enums.PaymentStatus;

public class PaidSubscriptionDTO {
    private Long id;
    private Long recruiterId;
    private Long employeeId;
    private Long planId;
    private String userEmail;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double amount;
    private String currency;
    private PaymentStatus paymentStatus;
    private String invoiceUrl;
    
    // Constructors
    public PaidSubscriptionDTO() {}
    
    public PaidSubscriptionDTO(Long id, Long recruiterId, Long employeeId, String currency, 
                              Long planId, Double amount, String userEmail, LocalDate startDate, 
                              LocalDate endDate, PaymentStatus paymentStatus, String invoiceUrl) {
        this.id = id;
        this.recruiterId = recruiterId;
        this.employeeId = employeeId;
        this.planId = planId;
        this.userEmail = userEmail;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
        this.currency = currency;
        this.paymentStatus = paymentStatus;
        this.invoiceUrl = invoiceUrl;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getRecruiterId() { return recruiterId; }
    public void setRecruiterId(Long recruiterId) { this.recruiterId = recruiterId; }
    
    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }
    
    public Long getPlanId() { return planId; }
    public void setPlanId(Long planId) { this.planId = planId; }
    
    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
    
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
    
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    
    public PaymentStatus getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(PaymentStatus paymentStatus) { this.paymentStatus = paymentStatus; }
    
    public String getInvoiceUrl() { return invoiceUrl; }
    public void setInvoiceUrl(String invoiceUrl) { this.invoiceUrl = invoiceUrl; }
}