package com.example.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dtos.students.StudentCreateDTO;
import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student create(StudentCreateDTO studentDTO) {
        Student student = new Student(studentDTO);
        return studentRepository.save(student);
    }
}