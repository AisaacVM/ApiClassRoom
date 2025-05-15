package com.example.ApiClassRoom.controllers;

import com.example.ApiClassRoom.models.Course;
import com.example.ApiClassRoom.services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseServices courseServices;

    // CREATE
    @PostMapping
    public Course saveCourse(@RequestBody Course course) throws Exception {
        return courseServices.saveCourse(course);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Course modifyCourse(@PathVariable Integer id, @RequestBody Course course) throws Exception {
        return courseServices.modifyCourse(id, course);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Integer id) throws Exception {
        return courseServices.searchCourseById(id);
    }

    // GET ALL
    @GetMapping
    public List<Course> getAllCourses() throws Exception {
        return courseServices.searchEveryCourse();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public boolean deleteCourse(@PathVariable Integer id) throws Exception {
        return courseServices.deleteCourse(id);
    }
}
