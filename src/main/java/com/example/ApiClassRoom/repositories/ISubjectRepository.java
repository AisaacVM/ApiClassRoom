package com.example.ApiClassRoom.repositories;

import com.example.ApiClassRoom.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubjectRepository extends JpaRepository<Subject,Integer> {
}
