package com.example.demo.service;



import java.util.List;

import com.example.demo.entity.Student;
import org.springframework.stereotype.Service;

@Service

public interface StudentsService {
    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudentByID(Long id);

    Student updateStudent(Student student);
    void deleteStudent(Long id);
}
