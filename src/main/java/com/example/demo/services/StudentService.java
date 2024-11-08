package com.example.demo.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.dtos.students.StudentCreateDTO;
import com.example.demo.dtos.students.StudentDTO;
import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream().map(user -> {
            return new StudentDTO(user);
        }).collect(Collectors.toList());
    }

    public Student getStudentById(Long id) {
        Optional<Student> studenOptional = studentRepository.findById(id);
        return studenOptional.orElseThrow(() -> new RuntimeException("Estudante não encontrado!")); 
    }

    public Student create(StudentCreateDTO studentDTO) {
        Student student = new Student(studentDTO);
        return studentRepository.save(student);
    }

    public ResponseEntity<?> deleteStudentById(Long id) {
        studentRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build(); 
    }
}