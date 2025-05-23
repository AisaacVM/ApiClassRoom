package com.example.ApiClassRoom.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name= "grades")
public class Grades {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "grades_id")
    private Integer id;


    @Column(precision = 5, scale = 2, nullable = false)
    private BigDecimal mark;

    @Column(name = "exam_date", nullable = false)
    private LocalDateTime exam;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", nullable = false)
    @JsonBackReference(value = "grades-student")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id", nullable = false)
    @JsonBackReference(value = "grades-subject")
    private Subject subject;

    public Grades() {
    }

    public Grades(Integer id, BigDecimal mark, LocalDateTime exam) {
        this.id = id;
        this.mark = mark;
        this.exam = exam;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMark() {
        return mark;
    }

    public void setMark(BigDecimal mark) {
        this.mark = mark;
    }

    public LocalDateTime getExam() {
        return exam;
    }

    public void setExam(LocalDateTime exam) {
        this.exam = exam;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
