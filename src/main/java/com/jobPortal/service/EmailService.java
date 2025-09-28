package com.jobPortal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.jobPortal.dto.EmailRequest;

@Service
public class EmailService {
    
    @Autowired
    private JavaMailSender mailSender;
    
    public String sendEmail(EmailRequest request) {
        try {
            // Create email message object
            SimpleMailMessage message = new SimpleMailMessage();
            
            // Set email details from the request
            message.setTo(request.getTo());           // Set recipient
            message.setSubject(request.getSubject()); // Set subject line
            message.setText(request.getBody());       // Set message body
            
            // Send the email
            mailSender.send(message);
            
            return "Email sent to " + request.getTo();
        } catch(Exception e) {
            return "Failed to send email: " + e.getMessage();
        }
    }
}