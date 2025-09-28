package com.jobPortal.dto;

import com.jobPortal.enums.UserRole;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO {
    private String email;
    private String password;
    private UserRole role;
    
    // For Student
    private String firstName;
    private String lastName;
    
    // For Recruiter
    private String companyName;
    
    // Getters and Setters
    
}