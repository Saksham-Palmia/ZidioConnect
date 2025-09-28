package com.jobPortal.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.jobPortal.enums.PaymentStatus;
import com.jobPortal.enums.PaymentType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDTO {
    private Long id;
    private Long userId;
    private Long planId;
    private String transactionId;
    private BigDecimal amount;
    private String currency;
    private PaymentStatus paymentStatus;
    private PaymentType paymentType;
    private LocalDateTime paymentDate;
    
    // Constructors
    public PaymentDTO() {}
    
    public PaymentDTO(Long id, Long userId, Long planId, BigDecimal amount, String currency, 
                     PaymentStatus paymentStatus, String transactionId, PaymentType paymentType, 
                     LocalDateTime paymentDate) {
        this.id = id;
        this.userId = userId;
        this.planId = planId;
        this.amount = amount;
        this.currency = currency;
        this.paymentStatus = paymentStatus;
        this.transactionId = transactionId;
        this.paymentType = paymentType;
        this.paymentDate = paymentDate;
    }
    
    // Getters and Setters
   
}