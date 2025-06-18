package com.codiapp.codi.domain.brief.dto.request;

import java.time.LocalDateTime;

public record BriefCreateRequestDTO(
        Long courseId,
        String title,
        LocalDateTime dueDate
) {}
