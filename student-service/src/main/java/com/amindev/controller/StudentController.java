package com.amindev.controller;

import com.amindev.dto.StudentDTO;
import com.amindev.exception.NotFoundException;
import com.amindev.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@Validated
public class StudentController {

    private final StudentService studentService;
    private final Logger LOG = LoggerFactory.getLogger(StudentController.class);

    @GetMapping
    public List<StudentDTO> findStudent() {
        LOG.info("start findStudent");
        System.out.println("stu serv 1");
        List<StudentDTO> studentDTOList = studentService.findStudent();
        LOG.info("end findStudent");
        return studentDTOList;
    }


    @GetMapping("/{id}")
    public StudentDTO findStudentById(@PathVariable("id") Long id) throws NotFoundException {
        LOG.info("start findStudentById {}", id);
        StudentDTO foundStudent = studentService.findStudentById(id);
        LOG.info("end findStudentById {}", id);
        return foundStudent;
    }

    @PutMapping("/{id}")
    public StudentDTO putStudent(@PathVariable("id") Long id,@Valid @RequestBody StudentDTO student) throws NotFoundException {
        LOG.info("start putStudent {}", student);
        StudentDTO updatedStudent = studentService.putStudent(id, student);
        LOG.info("end putStudent {}", student);
        return updatedStudent;
    }

    @DeleteMapping("/{id}")
    public Long deleteStudentById(@PathVariable("id") Long id) {
        LOG.info("start deleteStudentById {}", id);
        Long deletedStudent = studentService.deleteStudent(id);
        LOG.info("end deleteStudentById {}", id);
        return deletedStudent;
    }
}
