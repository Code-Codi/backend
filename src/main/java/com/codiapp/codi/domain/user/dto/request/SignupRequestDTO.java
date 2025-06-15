package com.codiapp.codi.domain.user.dto.request;

import java.time.LocalDate;

import com.codiapp.codi.domain.user.entity.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class SignupRequestDTO {

    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "이메일 형식이 잘못되었습니다.")
    private String email;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Size(min = 8, message = "비밀번호는 최소 8자 이상이어야 합니다.")
    private String password;

    @NotBlank(message = "이름을 입력해주세요.")
    private String username;

    @NotNull(message = "생년월일을 입력해주세요.")
    @Past
    private LocalDate birthDate;

    @NotNull(message = "역할을 선택해주세요.")
    private UserRole role;
}
