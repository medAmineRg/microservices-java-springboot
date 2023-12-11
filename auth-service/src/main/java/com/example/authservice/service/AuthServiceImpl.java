package com.example.authservice.service;

import com.example.authservice.dto.AuthRequest;
import com.example.authservice.entity.MyUserDetails;
import com.example.authservice.entity.Student;
import com.example.authservice.mapper.StudentMapper;
import com.example.authservice.repository.AuthRepository;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private static final StudentMapper studentMapper = Mappers.getMapper(StudentMapper.class);
    public final AuthRepository authRepository;

    @Override
    public AuthRequest postUser(AuthRequest student) {
        student.setPassword(new BCryptPasswordEncoder().encode(student.getPassword()));
        return studentMapper.studentEntityToDTO(authRepository.save(studentMapper.studentDTOToEntity(student)));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Student> student = authRepository.findByUsername(username);
        return student.map(MyUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("Student not found"));
    }
}
