package com.example.ApiClassRoom.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Subjects")
    public class Subject {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "subject_id")
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;

    @ManyToOne
    @JoinColumn(name = "fk_course", referencedColumnName = "course_id")
    @JsonBackReference(value="subjects-course")
    private Course course;

    @OneToMany(mappedBy = "subject")
    @JsonManagedReference(value = "grades-subject")
    private List<Grades> grades;


    public Subject() {
    }

    public Subject(Integer id, String name, Course course, List<Grades> grades) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.grades = grades;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Grades> getGrades() {
        return grades;
    }

    public void setGrades(List<Grades> grades) {
        this.grades = grades;
    }
}
