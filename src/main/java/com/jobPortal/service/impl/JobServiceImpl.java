package com.jobPortal.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobPortal.dto.JobDTO;
import com.jobPortal.entity.Job;
import com.jobPortal.entity.Recruiter;
import com.jobPortal.enums.JobType;
import com.jobPortal.repository.JobRepository;
import com.jobPortal.repository.RecruiterRepository;
import com.jobPortal.service.JobService;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;
    
    @Autowired
    private RecruiterRepository recruiterRepository;
    
    @Override
    public Job createJob(JobDTO jobDTO, Long recruiterId) {
        Optional<Recruiter> recruiterOptional = recruiterRepository.findById(recruiterId);
        if (!recruiterOptional.isPresent()) {
            throw new RuntimeException("Recruiter not found");
        }
        
        Job job = new Job();
        job.setTitle(jobDTO.getTitle());
        job.setDescription(jobDTO.getDescription());
        job.setRequirements(jobDTO.getRequirements());
        job.setLocation(jobDTO.getLocation());
        job.setSalary(jobDTO.getSalary());
        job.setType(JobType.valueOf(jobDTO.getType().name()));
        job.setDeadline(jobDTO.getDeadline());
        job.setRecruiter(recruiterOptional.get());
        
        return jobRepository.save(job);
    }
    
    @Override
    public Job updateJob(Long id, JobDTO jobDTO) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if (!jobOptional.isPresent()) {
            throw new RuntimeException("Job not found");
        }
        
        Job job = jobOptional.get();
        job.setTitle(jobDTO.getTitle());
        job.setDescription(jobDTO.getDescription());
        job.setRequirements(jobDTO.getRequirements());
        job.setLocation(jobDTO.getLocation());
        job.setSalary(jobDTO.getSalary());
        job.setType(JobType.valueOf(jobDTO.getType().name()));
        job.setDeadline(jobDTO.getDeadline());
        
        return jobRepository.save(job);
    }
    
    @Override
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
    
    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Job not found"));
    }
    
    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
    
    @Override
    public List<Job> searchJobs(String title, String location, String type) {
        if (title != null && location != null && type != null) {
            return jobRepository.findByTitleContainingIgnoreCaseAndLocationContainingIgnoreCaseAndType(
                title, location, type);
        } else if (title != null && location != null) {
            return jobRepository.findByTitleContainingIgnoreCaseAndLocationContainingIgnoreCase(
                title, location);
        } else if (title != null) {
            return jobRepository.findByTitleContainingIgnoreCase(title);
        } else if (location != null) {
            return jobRepository.findByLocationContainingIgnoreCase(location);
        } else if (type != null) {
            return jobRepository.findByType(type);
        } else {
            return jobRepository.findAll();
        }
    }
    
    @Override
    public List<Job> getJobsByRecruiter(Long recruiterId) {
        return jobRepository.findByRecruiterId(recruiterId);
    }
}