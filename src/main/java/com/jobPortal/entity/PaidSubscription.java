package com.jobPortal.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jobPortal.enums.PaymentStatus;

@Entity
@Table(name = "paid_subscriptions")
public class PaidSubscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long recruiterId;
    private Long employeeId;
    private Long planId;
    private Double amount;
    private String userEmail;
    private LocalDate startDate;
    private LocalDate endDate;
    private String currency;
    
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    
    private String invoiceUrl;
    
    // Constructors
    public PaidSubscription() {}
    
    public PaidSubscription(Long recruiterId, Long employeeId, Long planId, String userEmail, 
                           String currency, LocalDate startDate, LocalDate endDate, Double amount, 
                           PaymentStatus paymentStatus, String invoiceUrl) {
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
    
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
    
    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
    
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    
    public PaymentStatus getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(PaymentStatus paymentStatus) { this.paymentStatus = paymentStatus; }
    
    public String getInvoiceUrl() { return invoiceUrl; }
    public void setInvoiceUrl(String invoiceUrl) { this.invoiceUrl = invoiceUrl; }
}