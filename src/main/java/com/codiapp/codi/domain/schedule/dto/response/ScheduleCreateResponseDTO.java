package com.codiapp.codi.domain.schedule.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ScheduleCreateResponseDTO(
        Long id,
        LocalDateTime createdAt
) {
}
