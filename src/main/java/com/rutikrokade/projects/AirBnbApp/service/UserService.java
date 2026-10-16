package com.rutikrokade.projects.AirBnbApp.service;

import com.rutikrokade.projects.AirBnbApp.dto.ProfileUpdateRequestDto;
import com.rutikrokade.projects.AirBnbApp.dto.UserDto;
import com.rutikrokade.projects.AirBnbApp.entity.User;
import org.jspecify.annotations.Nullable;

public interface UserService {

    User getUserById(Long id);

    void updateProfile(ProfileUpdateRequestDto profileUpdateRequestDto);

    UserDto getMyProfile();
}
