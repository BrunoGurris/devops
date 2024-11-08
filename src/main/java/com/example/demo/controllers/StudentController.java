package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.dtos.students.StudentCreateDTO;
import com.example.demo.entities.Student;
import com.example.demo.services.StudentService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("")
    public ResponseEntity<Student> create(@RequestBody @Valid StudentCreateDTO studentDTO) {
        Student student = studentService.create(studentDTO);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }
}