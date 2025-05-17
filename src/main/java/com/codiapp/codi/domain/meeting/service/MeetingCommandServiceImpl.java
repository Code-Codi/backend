package com.codiapp.codi.domain.meeting.service;

import com.codiapp.codi.domain.meeting.converter.MeetingConverter;
import com.codiapp.codi.domain.meeting.dto.request.MeetingCreateRequestDTO;
import com.codiapp.codi.domain.meeting.dto.request.MeetingUpdateRequestDTO;
import com.codiapp.codi.domain.meeting.entity.Agenda;
import com.codiapp.codi.domain.meeting.entity.AgendaDetail;
import com.codiapp.codi.domain.meeting.entity.Decision;
import com.codiapp.codi.domain.meeting.entity.Meeting;
import com.codiapp.codi.domain.meeting.repository.MeetingRepository;
import com.codiapp.codi.domain.team.entity.Team;
import com.codiapp.codi.domain.team.repository.TeamRepository;
import com.codiapp.codi.global.apiPayload.code.status.ErrorStatus;
import com.codiapp.codi.global.apiPayload.exception.handler.MeetingHandler;
import com.codiapp.codi.global.apiPayload.exception.handler.TeamHandler;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MeetingCommandServiceImpl implements MeetingCommandService {

    private final MeetingRepository meetingRepository;
    private final TeamRepository teamRepository;

    @Override
    public Meeting createMeeting(MeetingCreateRequestDTO request) {
        Team team = teamRepository.findById(request.teamId())
                .orElseThrow(() -> new TeamHandler(ErrorStatus.TEAM_NOT_FOUND));

        Meeting meeting = MeetingConverter.toMeeting(request, team);
        return meetingRepository.save(meeting);
    }

    @Override
    @Transactional
    public Meeting updateMeeting(Long meetingId, MeetingUpdateRequestDTO request) {
        Meeting meeting = meetingRepository.findById(meetingId)
                .orElseThrow(() -> new MeetingHandler(ErrorStatus.MEETING_NOT_FOUND));

        // 기본 정보 수정
        meeting.update(request.title(), request.dateTime(), request.location());

        // 기존 Agenda, Decision 삭제
        meeting.getAgendas().clear();
        meeting.getDecisions().clear();

        // 새로운 Agenda 추가
        request.agendas().forEach(agendaDTO -> {
            Agenda agenda = Agenda.builder().title(agendaDTO.title()).build();
            agendaDTO.details().forEach(detailContent -> {
                AgendaDetail detail = AgendaDetail.builder().content(detailContent).build();
                agenda.addDetail(detail);
            });
            meeting.addAgenda(agenda);
        });

        // 새로운 Decision 추가
        request.decisions().forEach(content -> {
            Decision decision = Decision.builder().content(content).build();
            meeting.addDecision(decision);
        });

        return meeting;
    }

    @Override
    public void deleteMeeting(Long meetingId) {
        Meeting meeting = meetingRepository.findById(meetingId)
                .orElseThrow(() -> new MeetingHandler(ErrorStatus.MEETING_NOT_FOUND));

        meetingRepository.delete(meeting);
    }
}
