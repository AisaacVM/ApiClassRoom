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
    @JoinColumn(name = "fk_course", referencedColumnName = "id")
    @JsonBackReference
    Course course;

    @OneToMany(mappedBy = "subject")
    @JsonManagedReference
    private List<Grades> grades;


    public Subject() {
    }

    public Subject(Integer id, String name) {
        this.id = id;
        this.name = name;
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
}
