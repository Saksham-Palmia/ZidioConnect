package com.jobPortal.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jobPortal.enums.PaidStatus;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_payment_status")
@Getter
@Setter

public class UserPaymentStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long planId;
    private Long userId;
    private LocalDate subscriptionStart;
    private LocalDate subscriptionEnd;
    
    @Enumerated(EnumType.STRING)
    private PaidStatus status;
    
    // Constructors
    public UserPaymentStatus() {}
    
    public UserPaymentStatus(Long planId, Long userId, LocalDate subscriptionStart, 
                            LocalDate subscriptionEnd, PaidStatus status) {
        this.planId = planId;
        this.userId = userId;
        this.subscriptionStart = subscriptionStart;
        this.subscriptionEnd = subscriptionEnd;
        this.status = status;
    }
    
    // Getters and Setters from Lombok Annotations

}