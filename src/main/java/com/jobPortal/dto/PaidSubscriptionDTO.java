package com.jobPortal.dto;

import java.time.LocalDate;

import com.jobPortal.enums.PaymentStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
    
}