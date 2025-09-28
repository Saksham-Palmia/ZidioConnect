package com.jobPortal.service;

import java.util.List;

import com.jobPortal.dto.JobDTO;
import com.jobPortal.entity.Job;

public interface JobService {
    Job createJob(JobDTO jobDTO, Long recruiterId);
    Job updateJob(Long id, JobDTO jobDTO);
    void deleteJob(Long id);
    Job getJobById(Long id);
    List<Job> getAllJobs();
    List<Job> searchJobs(String title, String location, String type);
    List<Job> getJobsByRecruiter(Long recruiterId);
}