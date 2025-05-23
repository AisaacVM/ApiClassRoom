package com.example.ApiClassRoom.controllers;

import com.example.ApiClassRoom.models.Teacher;
import com.example.ApiClassRoom.models.User;
import com.example.ApiClassRoom.services.TeacherServices;
import com.example.ApiClassRoom.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    TeacherServices teacherServices;

    //CONTROLADOR PARA GUARDAR
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Teacher datasended){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.teacherServices.saveTeacher(datasended));
        }catch (Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    //CONTROLADOR PARA MODIFICAR
    @PutMapping("/{id}")
    public ResponseEntity<?> modify(@PathVariable Integer id, @RequestBody Teacher data) {
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.teacherServices.modifyTeacher(id,data));
        }catch (Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    //CONTROLADOR PARA BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.teacherServices.searchTeacherById(id));
        }catch (Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    //CONTROLADOR PARA BUSCAR TODOS
    @GetMapping
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.teacherServices.searchEveryTeacher());
        }catch (Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    //CONTROLADOR PARA BORRAR
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.teacherServices.deleteTeacher(id));
        }catch (Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
}

