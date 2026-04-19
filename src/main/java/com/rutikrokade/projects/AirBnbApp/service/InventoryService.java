package com.rutikrokade.projects.AirBnbApp.service;

import com.rutikrokade.projects.AirBnbApp.entity.Room;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);
}
