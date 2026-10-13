package com.rutikrokade.projects.AirBnbApp.dto;

import com.rutikrokade.projects.AirBnbApp.entity.User;
import com.rutikrokade.projects.AirBnbApp.entity.enums.Gender;
import lombok.Data;

@Data
public class GuestDto {
    private Long id;
    private User user;
    private String name;
    private Gender gender;
    private Integer age;
}
