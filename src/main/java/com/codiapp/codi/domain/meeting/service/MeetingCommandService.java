package com.codiapp.codi.domain.meeting.service;

import com.codiapp.codi.domain.meeting.dto.request.MeetingCreateRequestDTO;
import com.codiapp.codi.domain.meeting.dto.request.MeetingUpdateRequestDTO;
import com.codiapp.codi.domain.meeting.entity.Meeting;

public interface MeetingCommandService {
    Meeting createMeeting(MeetingCreateRequestDTO request);
    Meeting updateMeeting(Long meetingId, MeetingUpdateRequestDTO request);
    void deleteMeeting(Long meetingId);
}
