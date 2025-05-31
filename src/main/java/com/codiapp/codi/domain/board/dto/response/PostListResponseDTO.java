package com.codiapp.codi.domain.board.dto.response;

import java.time.LocalDateTime;

public record PostListResponseDTO(
    Long id,
    String title,
    String teamName,
    String type,
    int visitors,
    int favorites,
    LocalDateTime createdAt
) {}
