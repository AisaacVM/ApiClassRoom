package com.example.ApiClassRoom.controllers;

import com.example.ApiClassRoom.models.Subject;
import com.example.ApiClassRoom.services.SubjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectServices subjectServices;

    @PostMapping
    public Subject saveSubject(@RequestBody Subject subject) throws Exception {
        return subjectServices.saveSubject(subject);
    }

    @PutMapping("/{id}")
    public Subject modifySubject(@PathVariable Integer id, @RequestBody Subject subject) throws Exception {
        return subjectServices.modifySubject(id, subject);
    }

    @GetMapping("/{id}")
    public Subject getSubjectById(@PathVariable Integer id) throws Exception {
        return subjectServices.searchSubjectById(id);
    }

    @GetMapping
    public List<Subject> getAllSubjects() throws Exception {
        return subjectServices.searchEverySubject();
    }

    @DeleteMapping("/{id}")
    public boolean deleteSubject(@PathVariable Integer id) throws Exception {
        return subjectServices.deleteSubject(id);
    }
}
