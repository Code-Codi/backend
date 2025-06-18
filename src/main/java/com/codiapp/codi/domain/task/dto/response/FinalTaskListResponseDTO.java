package com.codiapp.codi.domain.task.dto.response;

import com.codiapp.codi.domain.task.entity.TaskStatus;

import java.time.LocalDateTime;

public record FinalTaskListResponseDTO(
        Long taskId,
        TaskStatus status,
        Long taskGuideId,
        String title,
        LocalDateTime dueDate,
        LocalDateTime createAt
) {}
