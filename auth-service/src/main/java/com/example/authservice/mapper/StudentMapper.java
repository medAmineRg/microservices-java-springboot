package com.example.authservice.mapper;

import com.example.authservice.dto.AuthRequest;
import com.example.authservice.entity.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    AuthRequest studentEntityToDTO(Student student);
    Student studentDTOToEntity(AuthRequest student);
}
