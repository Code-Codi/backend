package com.codiapp.codi.domain.login.converter;

import com.codiapp.codi.domain.login.dto.response.LoginResponseDTO;
import com.codiapp.codi.domain.login.entity.User;

public class UserConverter {
    public static LoginResponseDTO toLoginResponseDTO(User user) {
        return new LoginResponseDTO(user.getEmail(), user.getUsername());
    }
}
