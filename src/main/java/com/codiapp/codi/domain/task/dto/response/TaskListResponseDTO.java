package com.codiapp.codi.domain.task.dto.response;

import com.codiapp.codi.domain.task.entity.TaskStatus;

import java.time.LocalDate;

public record TaskListResponseDTO(
        Long id,
        TaskStatus status,
        LocalDate taskDate
) {}
