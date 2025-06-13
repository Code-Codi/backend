package com.codiapp.codi.domain.meeting.dto.request;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public record MeetingUpdateRequestDTO(
        String title,
        String dateTime,
        String location
) {}
