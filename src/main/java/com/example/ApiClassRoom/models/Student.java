package com.example.ApiClassRoom.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer id;

    @Column(nullable = false)
    private Integer degree;

    @Column(name = "birth_day", nullable = false)
    private LocalDateTime birthDay;

    @Column(nullable = false)
    private String address;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "student")
    @JsonManagedReference
    private List<Registration> registrations;

    @OneToMany(mappedBy = "student")
    @JsonManagedReference
    private List<Grades> grades;

    @OneToMany(mappedBy = "student")
    @JsonManagedReference
    private List<Attendance> attendance;

    public Student() {
    }

    public Student(Integer id,User user , Integer degree, LocalDateTime birthDay, String address, List<Registration> registrations) {
        this.id = id;
        this.user = user;
        this.degree = degree;
        this.birthDay = birthDay;
        this.address = address;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public LocalDateTime getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDateTime birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }

    public List<Grades> getGrades() {
        return grades;
    }

    public void setGrades(List<Grades> grades) {
        this.grades = grades;
    }

    public List<Attendance> getAttendance() {
        return attendance;
    }

    public void setAttendance(List<Attendance> attendance) {
        this.attendance = attendance;
    }
}

