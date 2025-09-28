package com.jobPortal.entity;

import com.jobPortal.enums.ApplicationStatus;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "applications")
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
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
    
    public Job getJob() { return job; }
    public void setJob(Job job) { this.job = job; }
    
    public ApplicationStatus getStatus() { return status; }
    public void setStatus(ApplicationStatus status) { this.status = status; }
    
    public LocalDateTime getAppliedDate() { return appliedDate; }
    public void setAppliedDate(LocalDateTime appliedDate) { this.appliedDate = appliedDate; }
    
    public String getCoverLetter() { return coverLetter; }
    public void setCoverLetter(String coverLetter) { this.coverLetter = coverLetter; }
}