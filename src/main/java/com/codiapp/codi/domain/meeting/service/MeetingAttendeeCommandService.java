package com.codiapp.codi.domain.meeting.service;

import com.codiapp.codi.domain.meeting.dto.request.MeetingAttendeeCreateRequestDTO;

public interface MeetingAttendeeCommandService {
    void createAttendees(MeetingAttendeeCreateRequestDTO request);
}
