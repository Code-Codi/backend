package com.codiapp.codi.domain.meeting.service;

import com.codiapp.codi.domain.meeting.dto.request.AgendaCreateRequestDTO;
import com.codiapp.codi.domain.meeting.dto.request.AgendaUpdateRequestDTO;
import com.codiapp.codi.domain.meeting.entity.Agenda;
import com.codiapp.codi.domain.meeting.entity.Meeting;
import com.codiapp.codi.domain.meeting.repository.AgendaRepository;
import com.codiapp.codi.domain.meeting.repository.MeetingRepository;
import com.codiapp.codi.global.apiPayload.code.status.ErrorStatus;
import com.codiapp.codi.global.apiPayload.exception.handler.MeetingHandler;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgendaCommandServiceImpl implements AgendaCommandService {

    private final AgendaRepository agendaRepository;
    private final MeetingRepository meetingRepository;

    @Override
    public Long create(AgendaCreateRequestDTO request) {
        Meeting meeting = meetingRepository.findById(request.meetingId())
                .orElseThrow(() -> new MeetingHandler(ErrorStatus.MEETING_NOT_FOUND));
        Agenda agenda = Agenda.builder()
                .title(request.title())
                .meeting(meeting)
                .build();
        return agendaRepository.save(agenda).getId();
    }

    @Override
    @Transactional
    public void update(Long agendaId, AgendaUpdateRequestDTO request) {
        Agenda agenda = agendaRepository.findById(agendaId)
                .orElseThrow(() -> new MeetingHandler(ErrorStatus.MEETING_NOT_FOUND));
        agenda.setTitle(request.title());
    }

    @Override
    public void delete(Long agendaId) {
        Agenda agenda = agendaRepository.findById(agendaId)
                .orElseThrow(() -> new MeetingHandler(ErrorStatus.MEETING_NOT_FOUND));
        agendaRepository.delete(agenda);
    }
}
