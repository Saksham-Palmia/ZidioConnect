package com.jobPortal.service;

import java.util.List;

import com.jobPortal.entity.User;

public interface AdminService {
    List<User> getAllUsers();
    User toggleUserStatus(Long id);
    void deleteUser(Long id);
    long getTotalUsers();
    long getTotalJobs();
    long getTotalApplications();
}