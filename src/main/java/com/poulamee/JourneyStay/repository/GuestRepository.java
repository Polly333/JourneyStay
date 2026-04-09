package com.poulamee.JourneyStay.repository;

import com.poulamee.JourneyStay.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest,Long> {
}
