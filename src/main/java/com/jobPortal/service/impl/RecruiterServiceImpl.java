package com.jobPortal.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobPortal.dto.RecruiterDTO;
import com.jobPortal.entity.Recruiter;
import com.jobPortal.repository.RecruiterRepository;
import com.jobPortal.service.RecruiterService;

@Service
public class RecruiterServiceImpl implements RecruiterService {

    @Autowired
    private RecruiterRepository recruiterRepository;
    
    @Override
    public Recruiter updateRecruiterProfile(Long id, RecruiterDTO recruiterDTO) {
        Optional<Recruiter> recruiterOptional = recruiterRepository.findById(id);
        if (!recruiterOptional.isPresent()) {
            throw new RuntimeException("Recruiter not found");
        }
        
        Recruiter recruiter = recruiterOptional.get();
        recruiter.setCompanyName(recruiterDTO.getCompanyName());
        recruiter.setCompanyAddress(recruiterDTO.getCompanyAddress());
        recruiter.setPhone(recruiterDTO.getPhone());
        recruiter.setWebsite(recruiterDTO.getWebsite());
        
        return recruiterRepository.save(recruiter);
    }
    
    @Override
    public Recruiter getRecruiterById(Long id) {
        return recruiterRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Recruiter not found"));
    }
    
    @Override
    public List<Recruiter> getAllRecruiters() {
        return recruiterRepository.findAll();
    }
}