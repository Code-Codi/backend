package com.codiapp.codi.domain.taskGuide.dto.response;

import com.codiapp.codi.domain.taskGuide.entity.TaskGuideStatus;

import java.time.LocalDateTime;

public record TaskGuideListResponseDTO(
        Long id,
        String title,
        LocalDateTime dueDate,
        LocalDateTime createAt,
        TaskGuideStatus status
) {}
