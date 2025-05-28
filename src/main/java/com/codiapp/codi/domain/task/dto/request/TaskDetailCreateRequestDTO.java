package com.codiapp.codi.domain.task.dto.request;

public record TaskDetailCreateRequestDTO(
        Long taskId,
        String title,
        String content
) {}
