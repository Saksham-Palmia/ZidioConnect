package com.jobPortal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobPortal.dto.UserPaymentStatusDTO;
import com.jobPortal.entity.UserPaymentStatus;
import com.jobPortal.repository.UserPaymentStatusRepository;

@Service
public class UserPaymentStatusService {
    
    @Autowired
    private UserPaymentStatusRepository userPaymentStatusRepository;
    
    public UserPaymentStatusDTO assignSubscriptionPlan(UserPaymentStatusDTO dto) {
        UserPaymentStatus paymentStatus = new UserPaymentStatus();
        paymentStatus.setUserId(dto.getUserId());
        paymentStatus.setPlanId(dto.getPlanId());
        paymentStatus.setSubscriptionStart(dto.getSubscriptionStart());
        paymentStatus.setSubscriptionEnd(dto.getSubscriptionEnd());
        paymentStatus.setStatus(dto.getStatus());
        
        UserPaymentStatus saved = userPaymentStatusRepository.save(paymentStatus);
        dto.setId(saved.getId());
        dto.setSubscriptionStart(saved.getSubscriptionStart());
        dto.setSubscriptionEnd(saved.getSubscriptionEnd());
        dto.setStatus(saved.getStatus());
        return dto;
    }
    
    public Optional<UserPaymentStatusDTO> getStatusByUserId(Long id) {
        return userPaymentStatusRepository.findByUserId(id).map(status -> {
            UserPaymentStatusDTO dto = new UserPaymentStatusDTO();
            dto.setId(status.getId());
            dto.setPlanId(status.getPlanId());
            dto.setUserId(status.getUserId());
            dto.setSubscriptionStart(status.getSubscriptionStart());
            dto.setSubscriptionEnd(status.getSubscriptionEnd());
            dto.setStatus(status.getStatus());
            return dto;
        });
    }
}