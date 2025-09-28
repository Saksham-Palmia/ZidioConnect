package com.jobPortal.entity;

import com.jobPortal.enums.ApplicationStatus;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "applications")
@Getter
@Setter
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;
    
    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;
    
    @Column(name = "applied_date")
    private LocalDateTime appliedDate;
    
    @Column(name = "cover_letter")
    private String coverLetter;
    
    // Constructors
    public Application() {
        this.appliedDate = LocalDateTime.now();
        this.status = ApplicationStatus.PENDING;
    }
    
    public Application(Student student, Job job) {
        this();
        this.student = student;
        this.job = job;
    }
    
    // Getters and Setters
   
}