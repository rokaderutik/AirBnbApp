package com.rutikrokade.projects.AirBnbApp.service;

import com.rutikrokade.projects.AirBnbApp.dto.HotelDto;
import com.rutikrokade.projects.AirBnbApp.dto.HotelInfoDto;

public interface HotelService {
    HotelDto createNewHotel(HotelDto hotelDto);

    HotelDto getHotelById(Long id);

    HotelDto updateHotelById(Long id, HotelDto hotelDto);

    void deleteHotelById(Long id);

    void activateHotel(Long id);

    HotelInfoDto getHotelInfoById(Long hotelId);
}
