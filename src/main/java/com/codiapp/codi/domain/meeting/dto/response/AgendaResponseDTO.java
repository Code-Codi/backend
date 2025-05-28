package com.codiapp.codi.domain.meeting.dto.response;

import java.util.List;

public record AgendaResponseDTO(
        Long id,
        String title,
        List<AgendaDetailResponseDTO> details
) {}
