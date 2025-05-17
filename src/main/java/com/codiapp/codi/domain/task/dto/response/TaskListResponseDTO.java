package com.codiapp.codi.domain.task.dto.response;

import com.codiapp.codi.domain.task.entity.TaskStatus;

import java.time.LocalDate;

public record TaskListResponseDTO(
        Long id,
        String title,
        TaskStatus status,
        LocalDate taskDate
) {}
