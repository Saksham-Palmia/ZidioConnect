package com.jobPortal.service;

import java.util.List;

import com.jobPortal.dto.ApplicationDTO;
import com.jobPortal.entity.Application;

public interface ApplicationService {
    Application createApplication(ApplicationDTO applicationDTO);
    Application updateApplicationStatus(Long id, String status);
    void deleteApplication(Long id);
    Application getApplicationById(Long id);
    List<Application> getApplicationsByStudent(Long studentId);
    List<Application> getApplicationsByJob(Long jobId);
    List<Application> getApplicationsByRecruiter(Long recruiterId);
}