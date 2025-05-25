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

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

   @PostMapping("/login")
public ResponseEntity<ApiResponse<LoginResponseDTO>> login(@RequestBody LoginRequestDTO request, HttpSession session) {
    return userService.login(request)
            .map(user -> {
                session.setAttribute("user", user);
                return ResponseEntity.ok(ApiResponse.onSuccess(user));
            })
            .orElseGet(() ->
                ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(ApiResponse.onFailure("LOGIN_FAIL", "이메일 또는 비밀번호가 일치하지 않습니다.", null))
            );
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
public ResponseEntity<ApiResponse<String>> signup(@RequestBody SignupRequestDTO dto) {
    try {
        userService.signup(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.onSuccess("회원가입 성공"));
    } catch (Exception e) {
        e.printStackTrace(); // 로그 확인용
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.onFailure("SIGNUP_FAIL", "회원가입 실패: " + e.getMessage(), null));
    }
}

}
