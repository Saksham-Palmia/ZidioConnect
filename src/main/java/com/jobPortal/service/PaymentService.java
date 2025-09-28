package com.jobPortal.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobPortal.dto.PaymentDTO;
import com.jobPortal.entity.Payment;
import com.jobPortal.repository.PaymentRepository;

@Service
public class PaymentService {
    
    @Autowired
    private PaymentRepository paymentRepository;
    
    public PaymentDTO makePayment(PaymentDTO dto) {
        Payment payment = new Payment();
        payment.setUserId(dto.getUserId());
        payment.setPlanId(dto.getPlanId());
        payment.setAmount(dto.getAmount());
        payment.setCurrency(dto.getCurrency());
        payment.setPaymentType(dto.getPaymentType());
        payment.setPaymentStatus(dto.getPaymentStatus());
        payment.setPaymentDate(dto.getPaymentDate());
        payment.setTransactionId(dto.getTransactionId());
        
        Payment saved = paymentRepository.save(payment);
        dto.setId(saved.getId());
        dto.setPaymentDate(saved.getPaymentDate());
        dto.setPaymentStatus(saved.getPaymentStatus());
        return dto;
    }
    
    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAll().stream().map(p -> {
            PaymentDTO dto = new PaymentDTO();
            dto.setId(p.getId());
            dto.setPlanId(p.getPlanId());
            dto.setUserId(p.getUserId());
            dto.setAmount(p.getAmount());
            dto.setCurrency(p.getCurrency());
            dto.setPaymentType(p.getPaymentType());
            dto.setPaymentStatus(p.getPaymentStatus());
            dto.setPaymentDate(p.getPaymentDate());
            dto.setTransactionId(p.getTransactionId());
            return dto;
        }).collect(Collectors.toList());
    }
}