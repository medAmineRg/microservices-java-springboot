package com.amindev.service;


import com.amindev.dto.StudentDTO;
import com.amindev.exception.NotFoundException;

import java.util.List;

public interface StudentService {
    List<StudentDTO> findStudent();
    StudentDTO findStudentById(Long id) throws NotFoundException;
    StudentDTO postStudent(StudentDTO student);
    StudentDTO putStudent(Long id, StudentDTO student) throws NotFoundException;
    Long deleteStudent(Long id);
}
