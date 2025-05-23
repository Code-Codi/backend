package com.codiapp.codi.domain.schedule.dto.response;

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
