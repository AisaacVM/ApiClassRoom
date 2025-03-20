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

    public Student(Integer id, Integer degree, LocalDateTime birthDay, String address, List<Registration> registrations) {
        this.id = id;
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


}

