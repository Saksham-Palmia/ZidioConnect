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

import com.jobPortal.dto.JobDTO;
import com.jobPortal.entity.Job;
import com.jobPortal.repository.security.CustomUserDetails;
import com.jobPortal.service.JobService;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "*")
public class JobController {

    @Autowired
    private JobService jobService;
    
    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        List<Job> jobs = jobService.getAllJobs();
        return ResponseEntity.ok(jobs);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Job job = jobService.getJobById(id);
        return ResponseEntity.ok(job);
    }
    
    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody JobDTO jobDTO, 
                                        @AuthenticationPrincipal CustomUserDetails userDetails) {
        Job job = jobService.createJob(jobDTO, userDetails.getUser().getId());
        return ResponseEntity.ok(job);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable Long id, @RequestBody JobDTO jobDTO) {
        Job job = jobService.updateJob(id, jobDTO);
        return ResponseEntity.ok(job);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Job>> searchJobs(@RequestParam(required = false) String title,
                                               @RequestParam(required = false) String location,
                                               @RequestParam(required = false) String type) {
        List<Job> jobs = jobService.searchJobs(title, location, type);
        return ResponseEntity.ok(jobs);
    }
    
    @GetMapping("/recruiter/{recruiterId}")
    public ResponseEntity<List<Job>> getJobsByRecruiter(@PathVariable Long recruiterId) {
        List<Job> jobs = jobService.getJobsByRecruiter(recruiterId);
        return ResponseEntity.ok(jobs);
    }
}