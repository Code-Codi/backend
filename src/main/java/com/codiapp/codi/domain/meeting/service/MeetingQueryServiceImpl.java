package com.codiapp.codi.domain.meeting.service;

import com.codiapp.codi.domain.meeting.converter.MeetingConverter;
import com.codiapp.codi.domain.meeting.dto.response.MeetingDetailResponseDTO;
import com.codiapp.codi.domain.meeting.dto.response.MeetingListResponseDTO;
import com.codiapp.codi.domain.meeting.entity.Meeting;
import com.codiapp.codi.domain.meeting.repository.MeetingRepository;
import com.codiapp.codi.global.apiPayload.code.status.ErrorStatus;
import com.codiapp.codi.global.apiPayload.exception.handler.MeetingHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MeetingQueryServiceImpl implements MeetingQueryService {

    private final MeetingRepository meetingRepository;

    @Override
    public MeetingDetailResponseDTO getMeetingDetail(Long meetingId) {
        Meeting meeting = meetingRepository.findById(meetingId)
                .orElseThrow(() -> new MeetingHandler(ErrorStatus.MEETING_NOT_FOUND));
        return MeetingConverter.toMeetingDetailResponseDTO(meeting);
    }

    @Override
    public Page<MeetingListResponseDTO> getMeetingList(Pageable pageable) {
        return meetingRepository.findAll(pageable)
                .map(MeetingConverter::toMeetingListDTO);
    }
}

