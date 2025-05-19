package com.codiapp.codi.domain.meeting.dto.request;

import java.util.List;

public record AgendaRequestDTO(
        String title,
        List<String> details
) {}
