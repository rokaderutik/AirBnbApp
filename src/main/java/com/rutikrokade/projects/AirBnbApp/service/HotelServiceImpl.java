package com.rutikrokade.projects.AirBnbApp.service;

import com.rutikrokade.projects.AirBnbApp.dto.HotelDto;
import com.rutikrokade.projects.AirBnbApp.dto.HotelInfoDto;
import com.rutikrokade.projects.AirBnbApp.dto.RoomDto;
import com.rutikrokade.projects.AirBnbApp.entity.Hotel;
import com.rutikrokade.projects.AirBnbApp.entity.Room;
import com.rutikrokade.projects.AirBnbApp.exception.ResourceNotFoundException;
import com.rutikrokade.projects.AirBnbApp.repository.HotelRepository;
import com.rutikrokade.projects.AirBnbApp.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final InventoryService inventoryService;
    private final ModelMapper modelMapper;
    private final RoomRepository roomRepository;

    @Override
    public HotelDto createNewHotel(HotelDto hotelDto) {
        log.info("Creating a new hotel with name: {}", hotelDto.getName());
        Hotel hotel = modelMapper.map(hotelDto, Hotel.class);
        hotel.setActive(false);
        hotel = hotelRepository.save(hotel);
        log.info("Created a new hotel with ID: {}", hotelDto.getId());
        return modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    public HotelDto getHotelById(Long id) {
        log.info("Getting the hotel with ID: {}", id);
        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: " + id));
        return modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    public HotelDto updateHotelById(Long id, HotelDto hotelDto) {
        log.info("Updating the hotel with ID: {}", id);
        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: " + id));
        modelMapper.map(hotelDto, hotel);
        hotel.setId(id);
        hotel = hotelRepository.save(hotel);
        return modelMapper.map(hotel, HotelDto.class);
    }

    @Transactional
    @Override
    public void deleteHotelById(Long id) {
        log.info("Deleting the hotel with ID: {}", id);
        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID:" + id));

        for (Room room : hotel.getRooms()) {
            inventoryService.deleteAllInventories(room);
            roomRepository.deleteById(room.getId());
        }

        hotelRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void activateHotel(Long id) {
        log.info("Activating hotel with ID: {}", id);
        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: " + id));

        hotel.setActive(true);

        for (Room room : hotel.getRooms()) {
            inventoryService.initializeRoomForAYear(room);
        }

    }

    @Override
    public HotelInfoDto getHotelInfoById(Long hotelId) {
        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: " + hotelId));

        List<RoomDto> rooms = hotel.getRooms()
                .stream()
                .map((element) -> modelMapper.map(element, RoomDto.class))
                .toList();

        return new HotelInfoDto(modelMapper.map(hotel, HotelDto.class), rooms);
    }


}
