package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    private StudentsService studentsService;

    public StudentController(StudentsService studentsService) {
        super();
        this.studentsService = studentsService;
    }

    //handler method to handle list students and return mode and view
    @GetMapping("/students")
    public String listStudents(Model model){
        model.addAttribute("students",studentsService.getAllStudents());
        return "students";

    }
    @GetMapping("/students/new")
    public String createStudentForm(Model model){
        //create student about to hold student form data
        Student student = new Student();
        model.addAttribute("student",student);
        return "create_student";
    }
    @PostMapping ("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentsService.saveStudent(student);
        return "redirect:/students";

    }
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model){
        model.addAttribute("student",studentsService.getStudentByID(id));
        return "edit_student";
    }
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("student") Student student,
                                Model model){
        // get student from database by id
        Student existingStudent = studentsService.getStudentByID(id);
        existingStudent.setId(student.getId());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());

        // save updated student object
        studentsService.updateStudent(existingStudent);
        return "redirect:/students";

    }
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentsService.deleteStudent(id);
        return "redirect:/students";
    }
}
