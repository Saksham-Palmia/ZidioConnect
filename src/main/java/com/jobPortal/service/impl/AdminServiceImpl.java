package com.jobPortal.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobPortal.entity.User;
import com.jobPortal.repository.ApplicationRepository;
import com.jobPortal.repository.JobRepository;
import com.jobPortal.repository.UserRepository;
import com.jobPortal.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private JobRepository jobRepository;
    
    @Autowired
    private ApplicationRepository applicationRepository;
    
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    @Override
    public User toggleUserStatus(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            throw new RuntimeException("User not found");
        }
        
        User user = userOptional.get();
        user.setEnabled(!user.isEnabled());
        
        return userRepository.save(user);
    }
    
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
    @Override
    public long getTotalUsers() {
        return userRepository.count();
    }
    
    @Override
    public long getTotalJobs() {
        return jobRepository.count();
    }
    
    @Override
    public long getTotalApplications() {
        return applicationRepository.count();
    }
}