package com.example.ApiClassRoom.controllers;

import com.example.ApiClassRoom.models.Student;
import com.example.ApiClassRoom.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentServices studentServices;

    @PostMapping
    public Student saveStudent(@RequestBody Student student) throws Exception {
        return studentServices.saveStudent(student);
    }
    @PutMapping("/{id}")
    public Student modifyStudent(@PathVariable Integer id, @RequestBody Student student) throws Exception {
        return studentServices.searchStudentById(id);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) throws Exception {
        return studentServices.searchStudentById(id);
    }

    @GetMapping
    public List<Student> getAllStudents() throws Exception {
        return  studentServices.searchEveryStudent();
    }

    @DeleteMapping("/{id}")
    public boolean deleteStudent(@PathVariable Integer id) throws Exception{
        return studentServices.deleteStudent(id);
    }

}
