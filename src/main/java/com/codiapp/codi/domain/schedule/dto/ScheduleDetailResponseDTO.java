package com.codiapp.codi.domain.schedule.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ScheduleDetailResponseDTO(
        Long id,
        String title,
        LocalDateTime startDate,
        LocalDateTime endDate,
        String content
) {
}
