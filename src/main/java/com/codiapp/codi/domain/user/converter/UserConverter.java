package com.codiapp.codi.domain.user.converter;

import com.codiapp.codi.domain.user.dto.request.SignupRequestDTO;
import com.codiapp.codi.domain.user.dto.response.LoginResponseDTO;
import com.codiapp.codi.domain.user.entity.User;

public class UserConverter {
    public static LoginResponseDTO toLoginResponseDTO(User user) {
        return LoginResponseDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

    public static User toUser(SignupRequestDTO dto, String encodedPassword) {
        return User.builder()
                .email(dto.getEmail())
                .password(encodedPassword)
                .username(dto.getUsername())
                .birthDate(dto.getBirthDate())
                .role(dto.getRole())
                .status("ACTIVE")
                .build();
    }
}
