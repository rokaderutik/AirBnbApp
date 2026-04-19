package com.rutikrokade.projects.AirBnbApp.repository;

import com.rutikrokade.projects.AirBnbApp.entity.Inventory;
import com.rutikrokade.projects.AirBnbApp.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    void deleteByRoom(Room room);
}
