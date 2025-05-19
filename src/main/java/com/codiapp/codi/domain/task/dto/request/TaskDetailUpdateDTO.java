package com.codiapp.codi.domain.task.dto.request;

public record TaskDetailUpdateDTO(
        Long id,
        String title,
        String content
) {}
