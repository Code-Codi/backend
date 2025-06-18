package com.codiapp.codi.domain.task.dto.response;

import com.codiapp.codi.domain.task.entity.TaskStatus;

import java.time.LocalDate;

public record FinalTeamListResponseDTO(
        Long taskId,
        TaskStatus status,
        LocalDate taskDate,
        Long teamId,
        Long courseId
) {}
