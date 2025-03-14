package com.example.ApiClassRoom.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Teacher {
private Integer id;
private String skill;

    //@OneToMany(mappedBy = "docente") Liberar cuando se tenga curso listo
    //@JsonManagedReference
    //private List<"Poner curso"> cursos;


    // (PARA CURSO)
    //ManyToOne
    //@JoinColumn(name= "fk_teacher",referencedColumnName = "id")
    //@JsonBackReference
    //Docente docente;
    public Teacher() {
    }

    public Teacher(Integer id, String skill) {
        this.id = id;
        this.skill = skill;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
