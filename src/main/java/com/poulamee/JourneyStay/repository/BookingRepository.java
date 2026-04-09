package com.poulamee.JourneyStay.repository;

import com.poulamee.JourneyStay.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long > {
}
