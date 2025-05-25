package com.codiapp.codi.domain.meeting.dto.response;

import java.time.LocalDateTime;

public record MeetingListResponseDTO(
        Long id,
        String title,
        String location,
        LocalDateTime dateTime
) {}
