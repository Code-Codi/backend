package com.codiapp.codi.domain.schedule.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ScheduleUpdateResponseDTO(
        Long id,
        LocalDateTime createdAt
) {
}
