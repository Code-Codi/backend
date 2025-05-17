package com.codiapp.codi.domain.schedule.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ScheduleCreateResponseDTO(
        Long id,
        LocalDateTime createdAt
) {
}
