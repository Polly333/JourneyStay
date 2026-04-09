package com.poulamee.JourneyStay.service;
import com.poulamee.JourneyStay.dto.RoomDto;

import java.util.List;


public interface RoomService {

    RoomDto createNewRoom(Long hotelId, RoomDto roomDto);

    List<RoomDto> getAllRoomsInHotel(Long hotelId);

    RoomDto getRoomById(Long roomId);

    void deleteRoomById(Long roomId);
}
