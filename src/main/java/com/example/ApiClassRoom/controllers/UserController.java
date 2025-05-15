package com.example.ApiClassRoom.controllers;

import com.example.ApiClassRoom.models.User;
import com.example.ApiClassRoom.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServices userServices;


    @PostMapping
    public User saveUser(@RequestBody User user) throws Exception {
        return userServices.saveUser(user);
    }


    @PutMapping("/{id}")
    public User modifyUser(@PathVariable Integer id, @RequestBody User user) throws Exception {
        return userServices.modifyUser(id, user);
    }


    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) throws Exception {
        return userServices.searchUserById(id);
    }


    @GetMapping
    public List<User> getAllUsers() throws Exception {
        return userServices.searchEveryUser();
    }


    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable Integer id) throws Exception {
        return userServices.deleteUser(id);
    }
}

