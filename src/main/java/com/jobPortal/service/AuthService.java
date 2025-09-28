package com.jobPortal.service;

import com.jobPortal.dto.LoginDTO;
import com.jobPortal.dto.RegisterDTO;
import com.jobPortal.entity.User;

public interface AuthService {
    User registerUser(RegisterDTO registerDTO);
    String loginUser(LoginDTO loginDTO);
}