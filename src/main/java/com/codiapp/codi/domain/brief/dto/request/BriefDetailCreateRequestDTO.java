package com.codiapp.codi.domain.brief.dto.request;

public record BriefDetailCreateRequestDTO(
    Long briefId,
    String title,
    String description
) { }
