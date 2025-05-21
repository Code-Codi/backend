package com.codiapp.codi.domain.meeting.dto.request;

public record DecisionCreateRequestDTO(
        Long meetingId,
        String content
) {}
