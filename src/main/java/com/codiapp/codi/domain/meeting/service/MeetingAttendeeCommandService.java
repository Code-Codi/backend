package com.codiapp.codi.domain.meeting.service;

import com.codiapp.codi.domain.meeting.dto.request.MeetingAttendeeCreateRequestDTO;

import java.util.List;

public interface MeetingAttendeeCommandService {
    void createAttendees(MeetingAttendeeCreateRequestDTO request);
    void updateAttendees(Long meetingId, List<Long> newAttendeeIds);
}
