package com.rutikrokade.projects.AirBnbApp.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class HotelContactInfo {
    private String address;
    private String location;
    private String phoneNumber;
    private String email;
}
