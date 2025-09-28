package com.jobPortal.controller;

import com.jobPortal.dto.ApplicationTrackDTO;
import com.jobPortal.dto.DashBoardDTO;
import com.jobPortal.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class AnalyticsController {
    
    @Autowired
    private AnalyticsService analyticsService;
    
    @GetMapping("/summary")
    public ResponseEntity<DashBoardDTO> getSummary() {
        return ResponseEntity.ok(analyticsService.getSummary());
    }
    
    @GetMapping("/applications/weekly")
    public ResponseEntity<List<ApplicationTrackDTO>> getWeeklyTrackers() {
        return ResponseEntity.ok(analyticsService.getWeeklyApplicationsTracker());
    }
}