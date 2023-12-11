package com.example.authservice.service;

import com.example.authservice.dto.AuthRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {
    AuthRequest postUser(AuthRequest student);
}
