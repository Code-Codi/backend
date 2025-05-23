package com.codiapp.codi.domain.meeting.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public record MeetingDetailResponseDTO(
        Long id,
        String title,
        LocalDateTime dateTime,
        String location,
        List<AgendaResponseDTO> agendas,
        List<DecisionResponseDTO> decisions
) {}

