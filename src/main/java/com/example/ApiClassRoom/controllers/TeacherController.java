package com.example.ApiClassRoom.controllers;

import com.example.ApiClassRoom.models.Teacher;
import com.example.ApiClassRoom.services.TeacherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherServices teacherServices;

    @PostMapping
    public Teacher saveTeacher(@RequestBody Teacher teacher) throws Exception {
        return teacherServices.saveTeacher(teacher);
    }
    @PutMapping("/{id}")
    public Teacher modifyTeacher(@PathVariable Integer id, @RequestBody Teacher teacher) throws Exception{
        return teacherServices.modifyTeacher(id, teacher);
    }
    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable Integer id) throws Exception{
        return teacherServices.searchTeacherById(id);
    }
    @GetMapping
    public List<Teacher> getAllTeachers() throws Exception {
        return  teacherServices.searchEveryTeacher();
    }
    @DeleteMapping("/{id}")
    public boolean deleteTeacher(@PathVariable Integer id) throws  Exception {
        return teacherServices.deleteTeacher(id);
    }
}
