package com.codiapp.codi.domain.task.dto.response;

import com.codiapp.codi.domain.task.entity.TaskStatus;

import java.time.LocalDate;
import java.util.List;

public record TaskResponseDTO(
        Long id,
        String title,
        TaskStatus status,
        LocalDate taskDate,
        List<TaskDetailResponseDTO> details
) {}
