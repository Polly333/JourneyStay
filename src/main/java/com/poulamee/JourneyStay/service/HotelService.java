package com.poulamee.JourneyStay.service;

import com.poulamee.JourneyStay.dto.HotelDto;
import com.poulamee.JourneyStay.dto.HotelInfoDto;

public interface HotelService {

 HotelDto createNewHotel(HotelDto hotelDto);

 HotelDto getHotelById(Long id);

 HotelDto updateHotelById(Long id, HotelDto hotelDto);

 void deleteHotelById(Long id);

 void activateHotel(Long hotelId);

 HotelInfoDto getHotelInfoById(Long hotelId);
}
