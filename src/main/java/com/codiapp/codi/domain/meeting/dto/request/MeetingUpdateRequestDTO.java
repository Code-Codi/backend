package com.codiapp.codi.domain.meeting.dto.request;

import java.time.LocalDateTime;
import java.util.List;

public record MeetingUpdateRequestDTO(
        String title,
        LocalDateTime dateTime,
        String location,
        List<AgendaRequestDTO> agendas,
        List<String> decisions
) {}
