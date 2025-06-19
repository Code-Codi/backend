package com.codiapp.codi.domain.meeting.dto.request;

import java.util.List;

public record MeetingAttendeeUpdateRequestDTO(
        Long meetingId,
        List<Long> attendeeIds // userTeamId 리스트
) {}
