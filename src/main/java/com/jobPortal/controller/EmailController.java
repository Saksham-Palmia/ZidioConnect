package com.jobPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobPortal.dto.EmailRequest;
import com.jobPortal.service.EmailService;

@RestController
@RequestMapping("/api/notify")
public class EmailController {
    
    @Autowired
    private EmailService emailService;
    
    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request) {
        String result = emailService.sendEmail(request);
        return ResponseEntity.ok(result);
    }
}