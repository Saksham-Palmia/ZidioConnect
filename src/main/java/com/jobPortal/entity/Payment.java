package com.jobPortal.entity;

import com.jobPortal.enums.PaymentStatus;
import com.jobPortal.enums.PaymentType;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long userId;
    private Long planId;
    private String transactionId;
    private BigDecimal amount;
    private String currency;
    
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
    
    private LocalDateTime paymentDate;
    
    // Constructors
    public Payment() {}
    
    public Payment(Long userId, Long planId, BigDecimal amount, String currency, 
                  PaymentStatus paymentStatus, String transactionId, PaymentType paymentType, 
                  LocalDateTime paymentDate) {
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