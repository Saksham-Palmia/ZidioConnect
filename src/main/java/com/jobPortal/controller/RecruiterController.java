package com.jobPortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobPortal.dto.RecruiterDTO;
import com.jobPortal.entity.Recruiter;
import com.jobPortal.repository.security.CustomUserDetails;
import com.jobPortal.service.RecruiterService;

@RestController
@RequestMapping("/api/recruiters")
@CrossOrigin(origins = "*")
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;
    
    @GetMapping("/profile")
    public ResponseEntity<Recruiter> getProfile(@AuthenticationPrincipal CustomUserDetails userDetails) {
        Recruiter recruiter = recruiterService.getRecruiterById(userDetails.getUser().getId());
        return ResponseEntity.ok(recruiter);
    }
    
    @PutMapping("/profile")
    public ResponseEntity<Recruiter> updateProfile(@RequestBody RecruiterDTO recruiterDTO,
                                                  @AuthenticationPrincipal CustomUserDetails userDetails) {
        Recruiter recruiter = recruiterService.updateRecruiterProfile(userDetails.getUser().getId(), recruiterDTO);
        return ResponseEntity.ok(recruiter);
    }
    
    @GetMapping
    public ResponseEntity<List<Recruiter>> getAllRecruiters() {
        List<Recruiter> recruiters = recruiterService.getAllRecruiters();
        return ResponseEntity.ok(recruiters);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Recruiter> getRecruiterById(@PathVariable Long id) {
        Recruiter recruiter = recruiterService.getRecruiterById(id);
        return ResponseEntity.ok(recruiter);
    }
}