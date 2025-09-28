package com.jobPortal.service;

import java.util.List;

import com.jobPortal.dto.RecruiterDTO;
import com.jobPortal.entity.Recruiter;

public interface RecruiterService {
    Recruiter updateRecruiterProfile(Long id, RecruiterDTO recruiterDTO);
    Recruiter getRecruiterById(Long id);
    List<Recruiter> getAllRecruiters();
}