package com.codiapp.codi.domain.board.dto.request;

public record PostUpdateRequestDTO(
    String title,
    String content,
    String thumbnail,
    String type
) { }
