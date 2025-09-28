package com.jobPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobPortal.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByTitleContainingIgnoreCase(String title);
    List<Job> findByLocationContainingIgnoreCase(String location);
    List<Job> findByType(String type);
    
    List<Job> findByTitleContainingIgnoreCaseAndLocationContainingIgnoreCaseAndType(
            String title, String location, String type);

    List<Job> findByTitleContainingIgnoreCaseAndLocationContainingIgnoreCase(
            String title, String location);

    List<Job> findByRecruiterId(Long recruiterId);
}