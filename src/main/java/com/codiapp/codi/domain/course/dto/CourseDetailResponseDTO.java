package com.codiapp.codi.domain.course.dto;

import lombok.Builder;

@Builder
public record CourseDetailResponseDTO(
        Long id,
        String name
) {
}
