package com.codiapp.codi.domain.login.dto.response;

public class SignupResponseDTO {
    private String email;
    private String username;
    private String message;

    public SignupResponseDTO(String email, String username, String message) {
        this.email = email;
        this.username = username;
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getMessage() {
        return message;
    }
}
