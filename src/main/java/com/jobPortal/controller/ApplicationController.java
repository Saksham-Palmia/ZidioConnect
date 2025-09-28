package com.jobPortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jobPortal.dto.ApplicationDTO;
import com.jobPortal.entity.Application;
import com.jobPortal.repository.security.CustomUserDetails;
import com.jobPortal.service.ApplicationService;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;
    
    @GetMapping
    public ResponseEntity<List<Application>> getApplications(@AuthenticationPrincipal CustomUserDetails userDetails) {
        List<Application> applications;
        
        String roleName = userDetails.getUser().getRole().name();
        switch (roleName) {
            case "STUDENT":
                applications = applicationService.getApplicationsByStudent(userDetails.getUser().getId());
                break;
            case "RECRUITER":
                applications = applicationService.getApplicationsByRecruiter(userDetails.getUser().getId());
                break;
            default:
                applications = applicationService.getApplicationsByRecruiter(userDetails.getUser().getId());
                break;
        }
        
        return ResponseEntity.ok(applications);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Application> getApplicationById(@PathVariable Long id) {
        Application application = applicationService.getApplicationById(id);
        return ResponseEntity.ok(application);
    }
    
    @PostMapping
    public ResponseEntity<Application> createApplication(@RequestBody ApplicationDTO applicationDTO,
                                                        @AuthenticationPrincipal CustomUserDetails userDetails) {
        applicationDTO.setStudentId(userDetails.getUser().getId());
        Application application = applicationService.createApplication(applicationDTO);
        return ResponseEntity.ok(application);
    }
    
    @PutMapping("/{id}/status")
    public ResponseEntity<Application> updateApplicationStatus(@PathVariable Long id, 
                                                              @RequestParam String status) {
        Application application = applicationService.updateApplicationStatus(id, status);
        return ResponseEntity.ok(application);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<Application>> getApplicationsByJob(@PathVariable Long jobId) {
        List<Application> applications = applicationService.getApplicationsByJob(jobId);
        return ResponseEntity.ok(applications);
    }
    
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Application>> getApplicationsByStudent(@PathVariable Long studentId) {
        List<Application> applications = applicationService.getApplicationsByStudent(studentId);
        return ResponseEntity.ok(applications);
    }
}