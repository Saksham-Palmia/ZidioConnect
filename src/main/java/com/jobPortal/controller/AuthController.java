package com.jobPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobPortal.dto.LoginDTO;
import com.jobPortal.dto.RegisterDTO;
import com.jobPortal.entity.User;
import com.jobPortal.repository.security.JwtUtil;
import com.jobPortal.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;
    
    @Autowired
    private JwtUtil jwtUtil;
    
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterDTO registerDTO) {
        try {
            User user = authService.registerUser(registerDTO);
            String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());
            
            return ResponseEntity.ok()
                .header("Authorization", "Bearer " + token)
                .body(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
        try {
            String token = authService.loginUser(loginDTO);
            
            return ResponseEntity.ok()
                .header("Authorization", "Bearer " + token)
                .body("Login successful");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}