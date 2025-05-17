package com.codiapp.codi.domain.meeting.converter;

import com.codiapp.codi.domain.meeting.dto.request.MeetingCreateRequestDTO;
import com.codiapp.codi.domain.meeting.dto.response.AgendaResponseDTO;
import com.codiapp.codi.domain.meeting.dto.response.MeetingDetailResponseDTO;
import com.codiapp.codi.domain.meeting.entity.*;
import com.codiapp.codi.domain.team.entity.Team;

import java.util.List;
import java.util.stream.Collectors;

public class MeetingConverter {

    public static Meeting toMeeting(MeetingCreateRequestDTO request, Team team) {
        Meeting meeting = Meeting.builder()
                .title(request.title())
                .dateTime(request.dateTime())
                .location(request.location())
                .team(team)
                .build();

        // 안건
        request.agendas().forEach(agendaDTO -> {
            Agenda agenda = Agenda.builder().title(agendaDTO.title()).build();
            agendaDTO.details().forEach(detailContent -> {
                AgendaDetail detail = AgendaDetail.builder().content(detailContent).build();
                agenda.addDetail(detail);
            });
            meeting.addAgenda(agenda);
        });

        // 결정사항
        request.decisions().forEach(content -> {
            Decision decision = Decision.builder().content(content).build();
            meeting.addDecision(decision);
        });

        return meeting;
    }

    public static MeetingDetailResponseDTO toMeetingDetailResponseDTO(Meeting meeting) {
        List<AgendaResponseDTO> agendas = meeting.getAgendas().stream()
                .map(agenda -> new AgendaResponseDTO(
                        agenda.getTitle(),
                        agenda.getDetails().stream()
                                .map(AgendaDetail::getContent)
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());

        List<String> decisions = meeting.getDecisions().stream()
                .map(Decision::getContent)
                .collect(Collectors.toList());

        return new MeetingDetailResponseDTO(
                meeting.getTitle(),
                meeting.getDateTime(),
                meeting.getLocation(),
                agendas,
                decisions
        );
    }
}


