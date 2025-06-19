package com.codiapp.codi.domain.meeting.service;

import com.codiapp.codi.domain.meeting.dto.request.MeetingAttendeeCreateRequestDTO;
import com.codiapp.codi.domain.meeting.entity.Meeting;
import com.codiapp.codi.domain.meeting.entity.MeetingAttendee;
import com.codiapp.codi.domain.meeting.repository.MeetingAttendeeRepository;
import com.codiapp.codi.domain.meeting.repository.MeetingRepository;
import com.codiapp.codi.domain.team.entity.UserTeam;
import com.codiapp.codi.domain.team.repository.UserTeamRepository;
import com.codiapp.codi.global.apiPayload.code.status.ErrorStatus;
import com.codiapp.codi.global.apiPayload.exception.handler.MeetingHandler;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MeetingAttendeeCommandServiceImpl implements MeetingAttendeeCommandService {

    private final MeetingRepository meetingRepository;
    private final UserTeamRepository userTeamRepository;
    private final MeetingAttendeeRepository meetingAttendeeRepository;

    @Override
    @Transactional
    public void createAttendees(MeetingAttendeeCreateRequestDTO request) {
        Meeting meeting = meetingRepository.findById(request.meetingId())
                .orElseThrow(() -> new MeetingHandler(ErrorStatus.MEETING_NOT_FOUND));

        for (Long userTeamId : request.attendeeIds()) {
            UserTeam userTeam = userTeamRepository.findById(userTeamId)
                    .orElseThrow(() -> new RuntimeException("UserTeam not found"));

            MeetingAttendee attendee = MeetingAttendee.builder()
                    .meeting(meeting)
                    .userTeam(userTeam)
                    .build();

            meetingAttendeeRepository.save(attendee);
        }
    }
}
