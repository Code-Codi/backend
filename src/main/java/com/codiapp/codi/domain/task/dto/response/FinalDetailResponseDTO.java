package com.codiapp.codi.domain.task.dto.response;

public record FinalDetailResponseDTO(
        //taskDetail
        Long taskDetailId,
        String content,
        //taskGuideDetail
        Long taskGuideDetailId,
        String title,
        String description

) {}
