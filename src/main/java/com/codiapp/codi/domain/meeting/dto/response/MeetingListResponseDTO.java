package com.codiapp.codi.domain.meeting.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public record MeetingListResponseDTO(
        Long id,
        String title,
        String location,
        LocalDateTime dateTime,
        List<String> attendees
) {}
