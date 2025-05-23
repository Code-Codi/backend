package com.codiapp.codi.domain.meeting.dto.request;

public record AgendaCreateRequestDTO(
        Long meetingId,
        String title
) {}
