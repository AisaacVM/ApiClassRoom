package com.example.ApiClassRoom.repositories;


import com.example.ApiClassRoom.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepository extends JpaRepository<Course,Integer> {



}
