package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.entities.Student;
import com.example.demo.entities.StudentEmail;
import com.example.demo.repositories.StudentRepository;

@SpringBootTest
@ActiveProfiles("test")
public class StudentTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testStudentCreate() {
        Student student = new Student();
        student.setName("Teste");
        student.setEmail(new StudentEmail("9VX2F@example.com"));
        Student studentSave = studentRepository.save(student);
        assertNotNull(studentSave.getId(), "O estudante não foi criado!");
    }


    @Test
    public void testFindAllStudents() {
        Student student = new Student();
        student.setName("Teste");
        student.setEmail(new StudentEmail("9VX2F@example.com"));
        studentRepository.save(student);

        List<Student> students = studentRepository.findAll();
        assertTrue(students.size() >= 1, "Deve haver um ou mais estudantes na lista!");
    }
}
