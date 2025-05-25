package com.codiapp.codi.domain.login.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codiapp.codi.domain.login.converter.UserConverter;
import com.codiapp.codi.domain.login.dto.request.LoginRequestDTO;
import com.codiapp.codi.domain.login.dto.request.SignupRequestDTO;
import com.codiapp.codi.domain.login.dto.response.LoginResponseDTO;
import com.codiapp.codi.domain.login.entity.User;
import com.codiapp.codi.domain.login.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<LoginResponseDTO> login(LoginRequestDTO requestDTO){
    Optional<User> userOpt = userRepository.findByEmail(requestDTO.email());
    
    if (userOpt.isEmpty()) {
        System.out.println("❌ 이메일 존재 안 함: " + requestDTO.email());
        return Optional.empty();
    }

    User user = userOpt.get();
    System.out.println("🔐 입력한 비번: " + requestDTO.password());
    System.out.println("🗃️ 저장된 해시 비번: " + user.getPassword());

    boolean matched = passwordEncoder.matches(requestDTO.password(), user.getPassword());
    System.out.println("✅ 패스워드 일치 여부: " + matched);

    if (matched) {
        return Optional.of(UserConverter.toLoginResponseDTO(user));
    } else {
        return Optional.empty();
    }
}


    public void signup(SignupRequestDTO dto) {
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("이미 가입된 이메일입니다.");
        }

        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setUsername(dto.getUsername());
        user.setBirthDate(dto.getBirthDate());

        userRepository.save(user);
    }
}
