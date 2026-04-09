package com.poulamee.JourneyStay.dto;

import com.poulamee.JourneyStay.entity.HotelContactInfo;
import lombok.Data;

//can add own validations
@Data
public class HotelDto {
    private Long id;
    private String name;
    private String city;
    private String[] photos;
    private String[] amenities;
    private HotelContactInfo contactInfo;
    private Boolean active;
}
