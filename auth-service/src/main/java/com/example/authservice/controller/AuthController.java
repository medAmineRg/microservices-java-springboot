package com.example.authservice.controller;

import com.example.authservice.dto.AuthRequest;
import com.example.authservice.service.AuthService;
import com.example.authservice.utils.JWTUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final JWTUtils jwtUtils;
    private final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/register")
    public String register(@Valid @RequestBody AuthRequest student) {
        LOG.info("start postStudent {}", student);
        authService.postUser(student);
        LOG.info("end postStudent {}", student);
        return "User created successfully";
    }


    @PostMapping()
    public String auth(@RequestBody AuthRequest authRequest) throws JsonProcessingException {
        UserDetails userDetails = authService.loadUserByUsername(authRequest.getUsername());
        return jwtUtils.generateToken(userDetails);
    }
}
