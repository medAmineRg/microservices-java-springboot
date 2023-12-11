package com.example.authservice.repository;

import com.example.authservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByUsername(String username);
}
