package com.example.authservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Student {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentID;
    @Column(name = "username", nullable = false)
    @NotEmpty
    @Size(min = 3, max = 25,message = "Username must be at least 3 char")
    private String username;
    @Column(name = "password", nullable = false)
    @Size(min = 8, max = 72, message = "password must be at least 8 char")
    private String password;
    private String role;
}
