package com.codiapp.codi.domain.user.service;

import com.codiapp.codi.domain.board.repository.PostRepository;
import com.codiapp.codi.domain.team.repository.UserTeamRepository;
import com.codiapp.codi.domain.user.converter.UserConverter;
import com.codiapp.codi.domain.user.dto.request.LoginRequestDTO;
import com.codiapp.codi.domain.user.dto.request.SignupRequestDTO;
import com.codiapp.codi.domain.user.dto.response.LoginResponseDTO;
import com.codiapp.codi.domain.user.entity.User;
import com.codiapp.codi.domain.user.repository.UserRepository;
import com.codiapp.codi.global.apiPayload.code.status.ErrorStatus;
import com.codiapp.codi.global.apiPayload.exception.handler.UserHandler;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserTeamRepository userTeamRepository;
    private final PostRepository postRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,  UserTeamRepository userTeamRepository, PostRepository postRepository){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userTeamRepository = userTeamRepository;
        this.postRepository = postRepository;
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

    //계정탈퇴
    @Transactional
     public void deleteUser(String email, String rawPassword) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));

        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new UserHandler(ErrorStatus.PASSWORD_NOT_MATCHED);
        }
        //자식 삭제
        userTeamRepository.deleteAllByUser_Id(user.getId());
        postRepository.deleteAllByWriterId(user.getId());

        //계정 삭제
        userRepository.delete(user);
    }
}
