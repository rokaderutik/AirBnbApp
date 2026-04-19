package com.rutikrokade.projects.AirBnbApp.repository;

import com.rutikrokade.projects.AirBnbApp.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
