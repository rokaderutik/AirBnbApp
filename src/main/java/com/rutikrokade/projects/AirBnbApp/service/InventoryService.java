package com.rutikrokade.projects.AirBnbApp.service;

import com.rutikrokade.projects.AirBnbApp.dto.HotelPriceDto;
import com.rutikrokade.projects.AirBnbApp.dto.HotelSearchRequest;
import com.rutikrokade.projects.AirBnbApp.dto.InventoryDto;
import com.rutikrokade.projects.AirBnbApp.dto.UpdateInventoryRequestDto;
import com.rutikrokade.projects.AirBnbApp.entity.Room;
import org.jspecify.annotations.Nullable;
import org.springframework.data.domain.Page;

import java.util.List;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);

    Page<HotelPriceDto> searchHotels(HotelSearchRequest hotelSearchRequest);

    List<InventoryDto> getAllInventoryByRoom(Long roomId);

    void updateInventory(Long roomId, UpdateInventoryRequestDto updateInventoryRequestDto);
}
