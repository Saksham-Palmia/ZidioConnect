package com.jobPortal.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobPortal.dto.SubscriptionPlanDTO;
import com.jobPortal.entity.SubscriptionPlan;
import com.jobPortal.repository.SubscriptionPlanRepository;

@Service
public class SubscriptionPlanService {
    
    @Autowired
    private SubscriptionPlanRepository subscriptionPlanRepository;
    
    public List<SubscriptionPlanDTO> getAllSubscriptionPlans() {
        return subscriptionPlanRepository.findAll().stream().map(sub -> {
            SubscriptionPlanDTO dto = new SubscriptionPlanDTO();
            dto.setId(sub.getId());
            dto.setName(sub.getName());
            dto.setPrice(sub.getPrice());
            dto.setDescription(sub.getDescription());
            dto.setDurationInDays(sub.getDurationInDays());
            return dto;
        }).collect(Collectors.toList());
    }
    
    public SubscriptionPlanDTO createSubscriptionPlan(SubscriptionPlanDTO dto) {
        SubscriptionPlan subscription = new SubscriptionPlan();
        subscription.setName(dto.getName());
        subscription.setPrice(dto.getPrice());
        subscription.setDescription(dto.getDescription());
        subscription.setDurationInDays(dto.getDurationInDays());
        
        SubscriptionPlan saved = subscriptionPlanRepository.save(subscription);
        dto.setId(saved.getId());
        return dto;
    }
}