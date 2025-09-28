package com.jobPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobPortal.entity.PaidSubscription;

@Repository
public interface PaidSubscriptionRepository extends JpaRepository<PaidSubscription, Long> {
    List<PaidSubscription> findByRecruiterId(Long recruiterId);
    List<PaidSubscription> findByEmployeeId(Long employeeId);
    List<PaidSubscription> findByUserEmail(String userEmail);
}