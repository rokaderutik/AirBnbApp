package com.rutikrokade.projects.AirBnbApp.repository;

import com.rutikrokade.projects.AirBnbApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}