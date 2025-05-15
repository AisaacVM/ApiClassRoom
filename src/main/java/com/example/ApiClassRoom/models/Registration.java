package com.example.ApiClassRoom.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Registrations")
    public class Registration {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "registration_id")
    private Integer id;

    @Column(name = "registration_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime registrationDate;

    @ManyToOne
    @JoinColumn(name = "fk_student", referencedColumnName = "student_id", nullable = false)
    @JsonBackReference
    Student student;

    @ManyToOne
    @JoinColumn(name= "fk-course", referencedColumnName = "course_id", nullable = false)
    @JsonBackReference
    Course course;

    public Registration() {
    }

    public Registration(Integer id, LocalDateTime registrationDate, Student student, Course course) {
        this.id = id;
        this.registrationDate = registrationDate;
        this.student = student;
        this.course = course;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
