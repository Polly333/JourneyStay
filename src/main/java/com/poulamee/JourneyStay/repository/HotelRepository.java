package com.poulamee.JourneyStay.repository;

import com.poulamee.JourneyStay.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
}
