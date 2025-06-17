package com.codiapp.codi.domain.brief.dto.response;


import java.time.LocalDateTime;
import java.util.List;

public record BriefResponseDTO(
        Long id,
        String title,
        LocalDateTime dueDate,
        LocalDateTime createAt,
        List<BriefDetailResponseDTO> details
) {}
