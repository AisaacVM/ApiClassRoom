package com.example.ApiClassRoom.controllers;

import com.example.ApiClassRoom.models.Registration;
import com.example.ApiClassRoom.services.RegistrationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {

    @Autowired
    private RegistrationServices registrationServices;


    @PostMapping
    public Registration saveRegistration(@RequestBody Registration registration) throws Exception {
        return registrationServices.saveRegistration(registration);
    }


    @PutMapping("/{id}")
    public Registration modifyRegistration(@PathVariable Integer id, @RequestBody Registration registration) throws Exception {
        return registrationServices.modifyRegistration(id, registration);
    }


    @GetMapping("/{id}")
    public Registration getRegistrationById(@PathVariable Integer id) throws Exception {
        return registrationServices.searchRegistrationById(id);
    }


    @GetMapping
    public List<Registration> getAllRegistrations() throws Exception {
        return registrationServices.searchEveryRegistration();
    }


    @DeleteMapping("/{id}")
    public boolean deleteRegistration(@PathVariable Integer id) throws Exception {
        return registrationServices.deleteRegistration(id);
    }
}
