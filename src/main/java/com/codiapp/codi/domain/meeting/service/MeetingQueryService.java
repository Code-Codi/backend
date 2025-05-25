package com.codiapp.codi.domain.meeting.service;

import com.codiapp.codi.domain.meeting.dto.response.MeetingDetailResponseDTO;
import com.codiapp.codi.domain.meeting.dto.response.MeetingListResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MeetingQueryService {
    MeetingDetailResponseDTO getMeetingDetail(Long meetingId);
    public Page<MeetingListResponseDTO> getMeetingList(Pageable pageable);
}
