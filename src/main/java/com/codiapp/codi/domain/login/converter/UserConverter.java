package com.codiapp.codi.domain.login.converter;

import com.codiapp.codi.domain.login.dto.request.SignupRequestDTO;
import com.codiapp.codi.domain.login.dto.response.LoginResponseDTO;
import com.codiapp.codi.domain.login.entity.User;

public class UserConverter {
    public static LoginResponseDTO toLoginResponseDTO(User user) {
        return new LoginResponseDTO(user.getEmail(), user.getUsername());
    }

    public static User toUser(SignupRequestDTO dto, String encodedPassword) {
    return User.builder()
        .email(dto.getEmail())
        .password(encodedPassword)
        .username(dto.getUsername())
        .birthDate(dto.getBirthDate())
        .status("ACTIVE") 
        .build();
}

}
