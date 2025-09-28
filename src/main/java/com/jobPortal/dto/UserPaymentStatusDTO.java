package com.jobPortal.dto;

import java.time.LocalDate;

import com.jobPortal.enums.PaidStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPaymentStatusDTO {
    private Long id;
    private Long planId;
    private Long userId;
    private LocalDate subscriptionStart;
    private LocalDate subscriptionEnd;
    private PaidStatus status;
    
    // Constructors
    public UserPaymentStatusDTO() {}
    
    public UserPaymentStatusDTO(Long id, Long planId, Long userId, LocalDate subscriptionStart, 
                               LocalDate subscriptionEnd, PaidStatus status) {
        this.id = id;
        this.planId = planId;
        this.userId = userId;
        this.subscriptionStart = subscriptionStart;
        this.subscriptionEnd = subscriptionEnd;
        this.status = status;
    }
    
    // Getters and Setters
  
}