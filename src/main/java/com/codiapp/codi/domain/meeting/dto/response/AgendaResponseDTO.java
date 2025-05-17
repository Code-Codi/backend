package com.codiapp.codi.domain.meeting.dto.response;

import java.util.List;

public record AgendaResponseDTO(
        String title,
        List<String> details
) {}
