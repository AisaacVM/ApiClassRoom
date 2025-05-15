package com.example.ApiClassRoom.controllers;

import com.example.ApiClassRoom.models.Grades;
import com.example.ApiClassRoom.services.GradeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grades")
public class GradeController {

    @Autowired
    private GradeServices gradeServices;


    @PostMapping
    public Grades saveGrades(@RequestBody Grades grades) throws Exception {
        return gradeServices.saveGrades(grades);
    }


    @PutMapping("/{id}")
    public Grades modifyGrades(@PathVariable Integer id, @RequestBody Grades grades) throws Exception {
        return gradeServices.modifyGrades(id, grades);
    }


    @GetMapping("/{id}")
    public Grades getGradesById(@PathVariable Integer id) throws Exception {
        return gradeServices.searchGradesById(id);
    }


    @GetMapping
    public List<Grades> getAllGrades() throws Exception {
        return gradeServices.searchEveryGrades();
    }

    @DeleteMapping("/{id}")
    public boolean deleteGrades(@PathVariable Integer id) throws Exception {
        return gradeServices.deleteGrades(id);
    }
}
