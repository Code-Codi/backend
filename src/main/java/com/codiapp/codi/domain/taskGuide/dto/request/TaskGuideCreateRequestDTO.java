package com.codiapp.codi.domain.taskGuide.dto.request;

import java.time.LocalDateTime;

public record TaskGuideCreateRequestDTO(
        Long courseId,
        String title,
        LocalDateTime dueDate
) {}
