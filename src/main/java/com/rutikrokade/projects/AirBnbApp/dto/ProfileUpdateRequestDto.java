package com.rutikrokade.projects.AirBnbApp.dto;

import com.rutikrokade.projects.AirBnbApp.entity.enums.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProfileUpdateRequestDto {
    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
}
