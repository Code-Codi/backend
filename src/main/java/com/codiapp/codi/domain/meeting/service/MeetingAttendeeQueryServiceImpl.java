package com.codiapp.codi.domain.meeting.service;



import com.codiapp.codi.domain.meeting.converter.MeetingConverter;
import com.codiapp.codi.domain.meeting.dto.response.MeetingAttendeeResponseDTO;
import com.codiapp.codi.domain.meeting.entity.MeetingAttendee;
import com.codiapp.codi.domain.meeting.repository.MeetingAttendeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeetingAttendeeQueryServiceImpl implements MeetingAttendeeQueryService{

    private final MeetingAttendeeRepository meetingAttendeeRepository;

    public List<MeetingAttendeeResponseDTO> getAttendeesByMeeting(Long meetingId) {
        List<MeetingAttendee> attendees = meetingAttendeeRepository.findByMeetingId(meetingId);
        return attendees.stream()
                .map(MeetingConverter::toDTO)
                .toList();
    }
}
