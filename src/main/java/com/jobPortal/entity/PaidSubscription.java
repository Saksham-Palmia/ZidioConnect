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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "paid_subscriptions")
@Getter
@Setter
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
    
}