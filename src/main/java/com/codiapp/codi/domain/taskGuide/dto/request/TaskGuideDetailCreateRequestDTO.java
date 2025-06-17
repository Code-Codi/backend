package com.codiapp.codi.domain.taskGuide.dto.request;

public record TaskGuideDetailCreateRequestDTO(
    Long taskGuideId,
    String title,
    String description
) { }
