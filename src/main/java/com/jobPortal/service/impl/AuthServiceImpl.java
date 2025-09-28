package com.jobPortal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jobPortal.dto.LoginDTO;
import com.jobPortal.dto.RegisterDTO;
import com.jobPortal.entity.Recruiter;
import com.jobPortal.entity.Student;
import com.jobPortal.entity.User;
import com.jobPortal.enums.UserRole;
import com.jobPortal.repository.UserRepository;
import com.jobPortal.repository.security.JwtUtil;
import com.jobPortal.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtUtil jwtUtil;
    
    @Override
    public User registerUser(RegisterDTO registerDTO) {
        if (userRepository.existsByEmail(registerDTO.getEmail())) {
            throw new RuntimeException("Email is already registered!");
        }
        
        User user;
        
        switch (registerDTO.getRole()) {
            case STUDENT: {
                Student student = new Student();
                student.setEmail(registerDTO.getEmail());
                student.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
                student.setRole(UserRole.STUDENT);
                student.setFirstName(registerDTO.getFirstName());
                student.setLastName(registerDTO.getLastName());
                user = student;
                break;
            }
            case RECRUITER: {
                Recruiter recruiter = new Recruiter();
                recruiter.setEmail(registerDTO.getEmail());
                recruiter.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
                recruiter.setRole(UserRole.RECRUITER);
                recruiter.setCompanyName(registerDTO.getCompanyName());
                user = recruiter;
                break;
            }
            default:
                throw new RuntimeException("Invalid user role");
        }
        
        return userRepository.save(user);
    }
    
    @Override
    public String loginUser(LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword())
        );
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        User user = userRepository.findByEmail(loginDTO.getEmail())
            .orElseThrow(() -> new RuntimeException("User not found"));
        
        return jwtUtil.generateToken(user.getEmail(), user.getRole().name());
    }
}