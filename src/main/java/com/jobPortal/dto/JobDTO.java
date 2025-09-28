package com.jobPortal.dto;

import java.time.LocalDateTime;

import com.jobPortal.enums.JobType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobDTO {
    private Long id;
    private String title;
    private String description;
    private String requirements;
    private String location;
    private Double salary;
    private JobType type;
    private LocalDateTime postedDate;
    private LocalDateTime deadline;
    private Long recruiterId;
    private String companyName;
    
    // Getters and Setters
    
}