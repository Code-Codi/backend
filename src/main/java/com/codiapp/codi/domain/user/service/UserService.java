package com.codiapp.codi.domain.user.service;

import com.codiapp.codi.domain.user.converter.UserConverter;
import com.codiapp.codi.domain.user.dto.request.LoginRequestDTO;
import com.codiapp.codi.domain.user.dto.request.SignupRequestDTO;
import com.codiapp.codi.domain.user.dto.response.LoginResponseDTO;
import com.codiapp.codi.domain.user.entity.User;
import com.codiapp.codi.domain.user.repository.UserRepository;
import com.codiapp.codi.global.apiPayload.code.status.ErrorStatus;
import com.codiapp.codi.global.apiPayload.exception.handler.UserHandler;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponseDTO login(LoginRequestDTO requestDTO){
        User user = userRepository.findByEmail(requestDTO.email())
            .orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));

        boolean matched = passwordEncoder.matches(requestDTO.password(), user.getPassword());
        if (!matched) {
            throw new UserHandler(ErrorStatus.PASSWORD_NOT_MATCHED);
        }

        return UserConverter.toLoginResponseDTO(user);
    }

    public void signup(SignupRequestDTO dto) {
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new UserHandler(ErrorStatus.EMAIL_ALREADY_EXISTS);
        }

        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        User user = UserConverter.toUser(dto, encodedPassword);
        userRepository.save(user);
    }
}
