package com.codiapp.codi.domain.user.dto.response;

import com.codiapp.codi.domain.user.entity.UserRole;
import lombok.Builder;

@Builder
public record LoginResponseDTO (
        Long id,
        String username,
        String email,
        UserRole role
) {}
