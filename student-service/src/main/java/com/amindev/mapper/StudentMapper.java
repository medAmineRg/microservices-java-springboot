package com.amindev.mapper;

import com.amindev.dto.StudentDTO;
import com.amindev.entity.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    StudentDTO studentEntityToDTO(Student student);
    Student studentDTOToEntity(StudentDTO student);

    List<StudentDTO> studentEntityListToDTO(List<Student> students);
    List<Student> studentDTOListToEntity(List<StudentDTO> students);
}
