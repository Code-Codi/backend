package com.codiapp.codi.domain.meeting.service;

import com.codiapp.codi.domain.meeting.dto.response.MeetingDetailResponseDTO;

public interface MeetingQueryService {
    MeetingDetailResponseDTO getMeetingDetail(Long meetingId);
}
