package com.jobPortal.service;

import com.jobPortal.dto.ApplicationTrackDTO;
import com.jobPortal.dto.DashBoardDTO;
import com.jobPortal.repository.ApplicationRepository;
import com.jobPortal.repository.JobRepository;
import com.jobPortal.repository.RecruiterRepository;
import com.jobPortal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnalyticsService {
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private RecruiterRepository recruiterRepository;
    
    @Autowired
    private JobRepository jobRepository;
    
    @Autowired
    private ApplicationRepository applicationRepository;
    
    public DashBoardDTO getSummary() {
        DashBoardDTO dto = new DashBoardDTO();
        
        dto.setTotalEmployees(studentRepository.count());
        dto.setTotalRecruiters(recruiterRepository.count());
        dto.setTotalJobs(jobRepository.count());
        dto.setTotalApplications(applicationRepository.count());
        
        return dto;
    }
    
    public List<ApplicationTrackDTO> getWeeklyApplicationsTracker() {
        List<ApplicationTrackDTO> tracker = new ArrayList<>();
        
        for (int i = 6; i >= 0; i--) {
            ApplicationTrackDTO dto = new ApplicationTrackDTO();
            dto.setDate(LocalDate.now().minusDays(i).toString());
            dto.setApplications(50 + (long)(Math.random() * 100));
            tracker.add(dto);
        }
        
        return tracker;
    }
}