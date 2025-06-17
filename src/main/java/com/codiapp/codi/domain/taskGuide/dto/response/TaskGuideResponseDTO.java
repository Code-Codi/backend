package com.codiapp.codi.domain.taskGuide.dto.response;


import java.time.LocalDateTime;
import java.util.List;

public record TaskGuideResponseDTO(
        Long id,
        String title,
        LocalDateTime dueDate,
        LocalDateTime createAt,
        List<TaskGuideDetailResponseDTO> details
) {}
