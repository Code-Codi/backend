package com.codiapp.codi.domain.task.dto.request;

import com.codiapp.codi.domain.task.entity.TaskStatus;

import java.time.LocalDate;
import java.util.List;

public record TaskCreateRequestDTO(
        Long teamId,
        String title,
        TaskStatus status,
        LocalDate taskDate,
        List<TaskDetailCreateDTO> details
) {}
