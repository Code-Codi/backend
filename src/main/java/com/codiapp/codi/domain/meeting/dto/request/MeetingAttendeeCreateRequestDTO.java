package com.codiapp.codi.domain.meeting.dto.request;

import java.util.List;

public record MeetingAttendeeCreateRequestDTO(
        Long meetingId,
        List<Long> attendeeIds // userTeamId 목록
) {}
