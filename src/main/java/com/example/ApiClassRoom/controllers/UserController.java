package com.example.ApiClassRoom.controllers;

import com.example.ApiClassRoom.models.User;
import com.example.ApiClassRoom.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServices userServices;

    //CONTROLADOR PARA GUARDAR
    @PostMapping
    public ResponseEntity<?> save(@RequestBody User datasended){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.userServices.saveUser(datasended));
    }catch (Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    //CONTROLADOR PARA MODIFICAR
    @PutMapping("/{id}")
    public ResponseEntity<?> modify(@PathVariable Integer id, @RequestBody User data) {
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.userServices.modifyUser(id,data));
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
                    .body(this.userServices.searchUserById(id));
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
                    .body(this.userServices.searchEveryUser());
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
                    .body(this.userServices.deleteUser(id));
        }catch (Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
}

