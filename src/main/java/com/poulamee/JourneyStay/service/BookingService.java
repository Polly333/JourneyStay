package com.poulamee.JourneyStay.service;

import com.poulamee.JourneyStay.dto.BookingDto;
import com.poulamee.JourneyStay.dto.BookingRequest;
import com.poulamee.JourneyStay.dto.GuestDto;

import java.util.List;

public interface BookingService {
    BookingDto initialiseBooking(BookingRequest bookingRequest);

    BookingDto addGuests(Long bookingId, List<GuestDto> guestDtoList);
}
