package com.poulamee.JourneyStay.service;

import com.poulamee.JourneyStay.dto.HotelPriceDto;
import com.poulamee.JourneyStay.dto.HotelSearchRequest;
import com.poulamee.JourneyStay.entity.Room;
import com.poulamee.JourneyStay.dto.HotelDto;
import org.springframework.data.domain.Page;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);

    Page<HotelPriceDto> searchHotels(HotelSearchRequest hotelSearchRequest);
}
