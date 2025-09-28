package com.jobPortal.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobPortal.dto.PaidSubscriptionDTO;
import com.jobPortal.service.PaidSubscriptionService;

@RestController
@RequestMapping("/api/subscriptions")
public class PaidSubscriptionController {
    
    @Autowired
    private PaidSubscriptionService paidSubscriptionService;
    
    @PostMapping
    public ResponseEntity<PaidSubscriptionDTO> createSubscription(@RequestBody PaidSubscriptionDTO dto) {
        return ResponseEntity.ok(paidSubscriptionService.createSubscription(dto));
    }
    
    @GetMapping("/user/{userEmail}")
    public ResponseEntity<List<PaidSubscriptionDTO>> getSubscriptionByUserEmail(@PathVariable String userEmail) {
        return ResponseEntity.ok(paidSubscriptionService.getSubscriptionByUserEmail(userEmail));
    }
    
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<PaidSubscriptionDTO>> getSubscriptionByEmployeeId(@PathVariable Long employeeId) {
        return ResponseEntity.ok(paidSubscriptionService.getSubscriptionByEmployeeId(employeeId));
    }
    
    @GetMapping("/recruiter/{recruiterId}")
    public ResponseEntity<List<PaidSubscriptionDTO>> getSubscriptionByRecruiterId(@PathVariable Long recruiterId) {
        return ResponseEntity.ok(paidSubscriptionService.getSubscriptionByRecruiterId(recruiterId));
    }
    
    @GetMapping
    public ResponseEntity<List<PaidSubscriptionDTO>> getAll() {
        return ResponseEntity.ok(paidSubscriptionService.getAll());
    }
    
    @GetMapping("/invoice/{id}")
    public ResponseEntity<InputStreamResource> downloadInvoice(@PathVariable Long id) {
        ByteArrayInputStream invoice = paidSubscriptionService.generateInvoice(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=invoice.pdf");
        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(invoice));
    }
}