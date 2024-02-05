package com.amindev.service;

import com.amindev.client.BookClient;
import com.amindev.dto.Book;
import com.amindev.dto.StudentDTO;
import com.amindev.entity.Student;
import com.amindev.exception.NotFoundException;
import com.amindev.mapper.StudentMapper;
import com.amindev.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{
    private static final StudentMapper studentMapper = Mappers.getMapper(StudentMapper.class);
    public final StudentRepository studentRepository;
    public final BookClient bookClient;

    @Override
    public List<StudentDTO> findStudent() {
        return studentMapper.studentEntityListToDTO(studentRepository.findAll());
    }

    @Override
    public StudentDTO findStudentById(Long id) throws NotFoundException {
        StudentDTO foundStudent = studentMapper.studentEntityToDTO(studentRepository.findById(id).orElseThrow(() -> new NotFoundException("user not found with id: "+id)));
        Book book = bookClient.getBookById(1L);
        List<Book> arrayBook = new ArrayList(List.of(book));
        foundStudent.setBooks(arrayBook);
        return foundStudent;
    }

    @Override
    public StudentDTO postStudent(StudentDTO student) {
        return studentMapper.studentEntityToDTO(studentRepository.save(studentMapper.studentDTOToEntity(student)));
    }

    @Override @Transactional
    public StudentDTO putStudent(Long id, StudentDTO student) throws NotFoundException {

        Student foundStudent = studentRepository.findById(id).orElseThrow(() -> new NotFoundException("user not found with id: "+id));
        foundStudent.setUsername(student.getUsername());
        return studentMapper.studentEntityToDTO(studentRepository.save(foundStudent));
    }

    @Override
    public Long deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return id;
    }

}
