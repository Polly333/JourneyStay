package com.poulamee.JourneyStay.dto;

import com.poulamee.JourneyStay.entity.User;
import com.poulamee.JourneyStay.entity.enums.Gender;
import lombok.Data;

@Data
public class GuestDto {
    private Long id;
    private User user; //understand
    private String name;
    private Gender gender;
    private Integer age;
}

