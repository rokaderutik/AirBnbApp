package com.rutikrokade.projects.AirBnbApp.service;

import com.rutikrokade.projects.AirBnbApp.dto.HotelDto;
import com.rutikrokade.projects.AirBnbApp.dto.HotelSearchRequest;
import com.rutikrokade.projects.AirBnbApp.entity.Room;
import org.springframework.data.domain.Page;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);

    Page<HotelDto> searchHotels(HotelSearchRequest hotelSearchRequest);
}
