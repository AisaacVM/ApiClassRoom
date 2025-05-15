package com.example.ApiClassRoom.repositories;

import com.example.ApiClassRoom.models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttendanceRepository extends JpaRepository<Attendance,Integer> {
}
