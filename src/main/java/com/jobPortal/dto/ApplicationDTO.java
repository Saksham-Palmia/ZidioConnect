package com.jobPortal.dto;

import java.time.LocalDateTime;

import com.jobPortal.enums.ApplicationStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationDTO {
    private Long id;
    private Long studentId;
    private Long jobId;
    private ApplicationStatus status;
    private LocalDateTime appliedDate;
    private String coverLetter;
    private String studentName;
    private String jobTitle;
    
    // Getters and Setters
    
}