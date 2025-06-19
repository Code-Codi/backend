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

import java.util.List;

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

    @Transactional
    public void updateAttendees(Long meetingId, List<Long> newAttendeeIds) {
        Meeting meeting = meetingRepository.findById(meetingId)
                .orElseThrow(() -> new MeetingHandler(ErrorStatus.MEETING_NOT_FOUND));

        // 1. 기존 참석자 전부 삭제
        meetingAttendeeRepository.deleteAllByMeetingId(meetingId);

        // 2. 새로운 참석자들 저장
        List<UserTeam> newUserTeams = userTeamRepository.findAllById(newAttendeeIds);
        for (UserTeam userTeam : newUserTeams) {
            MeetingAttendee attendee = MeetingAttendee.builder()
                    .meeting(meeting)
                    .userTeam(userTeam)
                    .build();
            meetingAttendeeRepository.save(attendee);
        }
    }
}
