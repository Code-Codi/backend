package com.codiapp.codi.domain.team.controller;

import com.codiapp.codi.domain.team.dto.response.UserNameResponseDTO;
import com.codiapp.codi.domain.team.entity.User;
import com.codiapp.codi.domain.team.repository.UserRepository;
import com.codiapp.codi.global.apiPayload.ApiResponse;
import com.codiapp.codi.global.apiPayload.code.status.SuccessStatus;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/email/{email}")
    public ApiResponse<UserNameResponseDTO> findByEmail(@PathVariable("email") String email) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new IllegalArgumentException("해당 이메일의 유저가 없습니다: " + email));

        return ApiResponse.of(SuccessStatus._OK,
                UserNameResponseDTO.builder()
                    .email(user.getEmail())
                    .userName(user.getUserName())
                    .build());
    }
}
