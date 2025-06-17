package com.codiapp.codi.domain.taskGuide.dto.request;

import java.time.LocalDateTime;

public record TaskGuideCreateRequestDTO(
        Long userId,
        String title,
        LocalDateTime dueDate
) {}
