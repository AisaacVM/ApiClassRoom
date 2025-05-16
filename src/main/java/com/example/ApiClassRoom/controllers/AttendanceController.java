package com.example.ApiClassRoom.controllers;

import com.example.ApiClassRoom.models.Attendance;
import com.example.ApiClassRoom.services.AttendanceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendances")
public class AttendanceController {

    @Autowired
    private AttendanceServices attendanceServices;

    // CREATE
    @PostMapping
    public Attendance saveAttendance(@RequestBody Attendance attendance) throws Exception {
        return attendanceServices.saveAttendance(attendance);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Attendance modifyAttendance(@PathVariable Integer id, @RequestBody Attendance attendance) throws Exception {
        return attendanceServices.modifyAttendance(id, attendance);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Attendance getAttendanceById(@PathVariable Integer id) throws Exception {
        return attendanceServices.searchAttendanceById(id);
    }

    // GET ALL
    @GetMapping
    public List<Attendance> getAllAttendances() throws Exception {
        return attendanceServices.searchEveryAttendance();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public boolean deleteAttendance(@PathVariable Integer id) throws Exception {
        return attendanceServices.deleteAttendance(id);
    }
}
