package com.Training.trainingPortal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Training.trainingPortal.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
   Optional<User> findByEmail(String email);
}
