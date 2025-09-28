package com.jobPortal.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jobPortal.enums.JobType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "jobs")
@Getter
@Setter
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String description;
    private String requirements;
    private String location;
    private Double salary;
    
    @Enumerated(EnumType.STRING)
    private JobType type;
    
    @Column(name = "posted_date")
    private LocalDateTime postedDate;
    
    private LocalDateTime deadline;
    
    @ManyToOne
    @JoinColumn(name = "recruiter_id")
    private Recruiter recruiter;
    
    // Constructors
    public Job() {
        this.postedDate = LocalDateTime.now();
    }
    
    public Job(String title, String description, Recruiter recruiter) {
        this();
        this.title = title;
        this.description = description;
        this.recruiter = recruiter;
    }
    
    // Getters and Setters
    
}