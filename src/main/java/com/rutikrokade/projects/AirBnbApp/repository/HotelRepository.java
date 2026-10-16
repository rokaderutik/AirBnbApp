package com.rutikrokade.projects.AirBnbApp.repository;

import com.rutikrokade.projects.AirBnbApp.entity.Hotel;
import com.rutikrokade.projects.AirBnbApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByOwner(User user);
}
