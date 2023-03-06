package com.example.demo.service.Impl;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Student;


import com.example.demo.Repository.StudentsRepository;
import com.example.demo.service.StudentsService;

@Service
public class StudentServiceImpl implements StudentsService {
private StudentsRepository studentsRepository;

    public StudentServiceImpl(StudentsRepository studentsRepository) {
        super();
        this.studentsRepository = studentsRepository;
    }

    @Override
    public List<Student> getAllStudents() {

        return studentsRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentsRepository.save(student);
    }

    @Override
    public Student getStudentByID(Long id) {
        return studentsRepository.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentsRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentsRepository.deleteById(id);
    }
}
