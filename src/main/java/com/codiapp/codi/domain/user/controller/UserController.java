package com.codiapp.codi.domain.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codiapp.codi.domain.user.dto.request.LoginRequestDTO;
import com.codiapp.codi.domain.user.dto.request.SignupRequestDTO;
import com.codiapp.codi.domain.user.dto.response.LoginResponseDTO;
import com.codiapp.codi.domain.user.entity.User;
import com.codiapp.codi.domain.user.repository.UserRepository;
import com.codiapp.codi.domain.user.service.UserService;
import com.codiapp.codi.domain.team.dto.response.UserNameResponseDTO;
import com.codiapp.codi.global.apiPayload.ApiResponse;
import com.codiapp.codi.global.apiPayload.code.status.SuccessStatus;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService, UserRepository userRepository){
        this.userService = userService;
        this.userRepository = userRepository;
    }
    
    private final UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponseDTO>> login(@RequestBody LoginRequestDTO request, HttpSession session) {
        LoginResponseDTO user = userService.login(request); 
        session.setAttribute("user", user);
        return ResponseEntity.ok(ApiResponse.onSuccess(user));
    }

    @GetMapping("/me")
    public ResponseEntity<ApiResponse<LoginResponseDTO>> me(HttpSession session) {
        LoginResponseDTO user = (LoginResponseDTO) session.getAttribute("user");
        if (user == null) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(ApiResponse.onFailure("UNAUTHORIZED", "로그인이 필요합니다.", null));
        }
        return ResponseEntity.ok(ApiResponse.onSuccess(user));
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "로그아웃 완료";
    }

    @Operation(
        summary = "회원가입",
        description = "회원가입 API",
        security = @SecurityRequirement(name = "")
    )
    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<String>> signup(@RequestBody @Valid SignupRequestDTO dto) {
        userService.signup(dto); // 예외 발생 시 ControllerAdvice로 처리됨
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.onSuccess("회원가입 성공"));
    }
    
    //Team워크스페이스 기능에 사용되는 유저 이메일 조회 메서드 
    @GetMapping("/email/{email}")
    public ApiResponse<UserNameResponseDTO> findByEmail(@PathVariable("email") String email) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new IllegalArgumentException("해당 이메일의 유저가 없습니다: " + email));

        return ApiResponse.of(SuccessStatus._OK,
                UserNameResponseDTO.builder()
                    .email(user.getEmail())
                    .userName(user.getUsername())
                    .build());
    }
}
