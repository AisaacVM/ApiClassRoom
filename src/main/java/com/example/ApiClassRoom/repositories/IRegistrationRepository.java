package com.example.ApiClassRoom.repositories;

import com.example.ApiClassRoom.models.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegistrationRepository  extends JpaRepository<Registration,Integer> {
}
