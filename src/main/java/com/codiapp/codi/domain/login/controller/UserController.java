package com.codiapp.codi.domain.login.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codiapp.codi.domain.login.dto.request.LoginRequestDTO;
import com.codiapp.codi.domain.login.dto.request.SignupRequestDTO;
import com.codiapp.codi.domain.login.dto.response.LoginResponseDTO;
import com.codiapp.codi.domain.login.service.UserService;
import com.codiapp.codi.global.apiPayload.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

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
}
