package com.example.ApiClassRoom.repositories;

import com.example.ApiClassRoom.models.Grades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGradesReposity extends JpaRepository<Grades,Integer> {
}
