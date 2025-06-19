package com.codiapp.codi.domain.meeting.service;

import com.codiapp.codi.domain.meeting.dto.response.MeetingAttendeeResponseDTO;

import java.util.List;

public interface MeetingAttendeeQueryService {
    List<MeetingAttendeeResponseDTO> getAttendeesByMeeting(Long meetingId);
}
