package com.poulamee.JourneyStay.service;

import com.poulamee.JourneyStay.dto.HotelDto;
import com.poulamee.JourneyStay.dto.HotelInfoDto;
import com.poulamee.JourneyStay.dto.RoomDto;
import com.poulamee.JourneyStay.entity.Hotel;
import com.poulamee.JourneyStay.entity.Room;
import com.poulamee.JourneyStay.exceptions.ResourceNotFoundException;
import com.poulamee.JourneyStay.repository.HotelRepository;
import com.poulamee.JourneyStay.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService{

    private final HotelRepository hotelRepo;
    private final RoomRepository roomRepo;
    private final ModelMapper mapper;
    private final InventoryService inventoryService;



    @Override
    public HotelDto createNewHotel(HotelDto hotelDto) {
        log.info("Creating a new hotel with name: {}", hotelDto.getName());
        Hotel hotel = mapper.map(hotelDto, Hotel.class);
        hotel.setActive(false);
        hotel = hotelRepo.save(hotel);
        log.info("Created a new hotel with ID: {}", hotelDto.getId());
        return mapper.map(hotel, HotelDto.class);
    }


    @Override
    public HotelDto getHotelById(Long id) {
        log.info("Getting the hotel with ID: {}", id);
        Hotel hotel = hotelRepo
                .findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Hotel not found with ID: "+id));
        return mapper.map(hotel, HotelDto.class);
    }

    //understand wht it does? - check postman body
    @Override
    public HotelDto updateHotelById(Long id, HotelDto hotelDto) {
        log.info("Updating the hotel with ID: {}", id);
        Hotel hotel = hotelRepo
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: "+id));
        mapper.map(hotelDto, hotel);
        hotel.setId(id);
        hotel = hotelRepo.save(hotel);
        return mapper.map(hotel, HotelDto.class);
    }


    @Override
    @Transactional
    public void deleteHotelById(Long id) {
        Hotel hotel = hotelRepo
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: "+id));

        for(Room room: hotel.getRooms()) {
            inventoryService.deleteAllInventories(room);
            roomRepo.deleteById(room.getId());
        }
        hotelRepo.deleteById(id);

    }

    @Override
    @Transactional
    public void activateHotel(Long hotelId) {
        log.info("Activating the hotel with ID: {}", hotelId);
        Hotel hotel = hotelRepo
                .findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: "+hotelId));

        hotel.setActive(true);

        // assuming only do it once
        for(Room room: hotel.getRooms()) {
            inventoryService.initializeRoomForAYear(room);
        }
    }


    @Override
    public HotelInfoDto getHotelInfoById(Long hotelId) {
        Hotel hotel = hotelRepo
                .findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: "+hotelId));

        List<RoomDto> rooms = hotel
                .getRooms()
                .stream()
                .map((element)-> mapper.map(element,RoomDto.class) )
                .toList();

        return new HotelInfoDto(mapper.map(hotel,HotelDto.class),rooms);

    }


}




