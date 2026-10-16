package com.rutikrokade.projects.AirBnbApp.repository;

import com.rutikrokade.projects.AirBnbApp.entity.Guest;
import com.rutikrokade.projects.AirBnbApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByUser(User user);
}
