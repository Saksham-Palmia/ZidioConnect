package com.jobPortal.service;

import com.jobPortal.dto.PaidSubscriptionDTO;
import com.jobPortal.entity.PaidSubscription;
import com.jobPortal.repository.PaidSubscriptionRepository;
import com.jobPortal.util.InvoiceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaidSubscriptionService {
    
    @Autowired
    private PaidSubscriptionRepository paidSubscriptionRepository;
    
    public PaidSubscriptionDTO createSubscription(PaidSubscriptionDTO dto) {
        PaidSubscription sub = new PaidSubscription();
        
        sub.setRecruiterId(dto.getRecruiterId());
        sub.setEmployeeId(dto.getEmployeeId());
        sub.setPlanId(dto.getPlanId());
        sub.setUserEmail(dto.getUserEmail());
        sub.setPaymentStatus(dto.getPaymentStatus());
        sub.setStartDate(dto.getStartDate());
        sub.setEndDate(dto.getEndDate());
        sub.setAmount(dto.getAmount());
        sub.setCurrency(dto.getCurrency());
        sub.setInvoiceUrl(dto.getInvoiceUrl());
        
        PaidSubscription saved = paidSubscriptionRepository.save(sub);
        return mapToDTO(saved);
    }
    
    public List<PaidSubscriptionDTO> getSubscriptionByUserEmail(String userEmail) {
        return paidSubscriptionRepository.findByUserEmail(userEmail).stream()
                .map(this::mapToDTO).collect(Collectors.toList());
    }
    
    public List<PaidSubscriptionDTO> getSubscriptionByEmployeeId(Long employeeId) {
        return paidSubscriptionRepository.findByEmployeeId(employeeId).stream()
                .map(this::mapToDTO).collect(Collectors.toList());
    }
    
    public List<PaidSubscriptionDTO> getSubscriptionByRecruiterId(Long recruiterId) {
        return paidSubscriptionRepository.findByRecruiterId(recruiterId).stream()
                .map(this::mapToDTO).collect(Collectors.toList());
    }
    
    public List<PaidSubscriptionDTO> getAll() {
        return paidSubscriptionRepository.findAll().stream()
                .map(this::mapToDTO).collect(Collectors.toList());
    }
    
    public ByteArrayInputStream generateInvoice(Long id) {
        PaidSubscription subscription = paidSubscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription not found"));
        return InvoiceGenerator.generateInvoice(subscription);
    }
    
    private PaidSubscriptionDTO mapToDTO(PaidSubscription sub) {
        PaidSubscriptionDTO dto = new PaidSubscriptionDTO();
        dto.setId(sub.getId());
        dto.setEmployeeId(sub.getEmployeeId());
        dto.setRecruiterId(sub.getRecruiterId());
        dto.setPlanId(sub.getPlanId());
        dto.setUserEmail(sub.getUserEmail());
        dto.setPaymentStatus(sub.getPaymentStatus());
        dto.setInvoiceUrl(sub.getInvoiceUrl());
        dto.setStartDate(sub.getStartDate());
        dto.setEndDate(sub.getEndDate());
        dto.setAmount(sub.getAmount());
        dto.setCurrency(sub.getCurrency());
        return dto;
    }
}