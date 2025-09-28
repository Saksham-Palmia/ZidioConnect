package com.jobPortal.service.impl;

import com.jobPortal.dto.ApplicationDTO;
import com.jobPortal.entity.Application;
import com.jobPortal.entity.Job;
import com.jobPortal.entity.Student;
import com.jobPortal.enums.ApplicationStatus;
import com.jobPortal.repository.ApplicationRepository;
import com.jobPortal.repository.JobRepository;
import com.jobPortal.repository.StudentRepository;
import com.jobPortal.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private JobRepository jobRepository;
    
    @Override
    public Application createApplication(ApplicationDTO applicationDTO) {
        Optional<Student> studentOptional = studentRepository.findById(applicationDTO.getStudentId());
        if (!studentOptional.isPresent()) {
            throw new RuntimeException("Student not found");
        }
        
        Optional<Job> jobOptional = jobRepository.findById(applicationDTO.getJobId());
        if (!jobOptional.isPresent()) {
            throw new RuntimeException("Job not found");
        }
        
        // Check if already applied
        List<Application> existingApplications = applicationRepository.findByStudentIdAndJobId(
            applicationDTO.getStudentId(), applicationDTO.getJobId());
        if (!existingApplications.isEmpty()) {
            throw new RuntimeException("Already applied for this job");
        }
        
        Application application = new Application();
        application.setStudent(studentOptional.get());
        application.setJob(jobOptional.get());
        application.setCoverLetter(applicationDTO.getCoverLetter());
        
        return applicationRepository.save(application);
    }
    
    @Override
    public Application updateApplicationStatus(Long id, String status) {
        Optional<Application> applicationOptional = applicationRepository.findById(id);
        if (!applicationOptional.isPresent()) {
            throw new RuntimeException("Application not found");
        }
        
        Application application = applicationOptional.get();
        application.setStatus(ApplicationStatus.valueOf(status.toUpperCase()));
        
        return applicationRepository.save(application);
    }
    
    @Override
    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }
    
    @Override
    public Application getApplicationById(Long id) {
        return applicationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Application not found"));
    }
    
    @Override
    public List<Application> getApplicationsByStudent(Long studentId) {
        return applicationRepository.findByStudentId(studentId);
    }
    
    @Override
    public List<Application> getApplicationsByJob(Long jobId) {
        return applicationRepository.findByJobId(jobId);
    }
    
    @Override
    public List<Application> getApplicationsByRecruiter(Long recruiterId) {
        return applicationRepository.findByJobRecruiterId(recruiterId);
    }
}