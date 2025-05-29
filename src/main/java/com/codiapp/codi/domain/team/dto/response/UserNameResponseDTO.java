package com.codiapp.codi.domain.team.dto.response;

import lombok.Builder;

@Builder
public record UserNameResponseDTO(
    String email,
    String userName
) {}
