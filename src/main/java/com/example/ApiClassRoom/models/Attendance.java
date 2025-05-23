package com.example.ApiClassRoom.models;

import com.example.ApiClassRoom.helpers.State;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "Attendances")
public class Attendance {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "attendance_id")
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private State state;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", nullable = false)
    @JsonBackReference(value = "student-attendance")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false)
    @JsonBackReference(value = "attendance-course")
    private Course course;
    public Attendance() {
    }

    public Attendance(Integer id, LocalDateTime date, State state, Student student, Course course) {
        this.id = id;
        this.date = date;
        this.state = state;
        this.student = student;
        this.course = course;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
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
