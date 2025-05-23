package com.codiapp.codi.domain.meeting.service;

import com.codiapp.codi.domain.meeting.dto.request.AgendaDetailCreateRequestDTO;
import com.codiapp.codi.domain.meeting.dto.request.AgendaDetailUpdateRequestDTO;
import com.codiapp.codi.domain.meeting.entity.Agenda;
import com.codiapp.codi.domain.meeting.entity.AgendaDetail;
import com.codiapp.codi.domain.meeting.repository.AgendaDetailRepository;
import com.codiapp.codi.domain.meeting.repository.AgendaRepository;
import com.codiapp.codi.global.apiPayload.code.status.ErrorStatus;
import com.codiapp.codi.global.apiPayload.exception.handler.MeetingHandler;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgendaDetailCommandServiceImpl implements AgendaDetailCommandService {

    private final AgendaRepository agendaRepository;
    private final AgendaDetailRepository agendaDetailRepository;

    @Override
    public Long create(AgendaDetailCreateRequestDTO request) {
        Agenda agenda = agendaRepository.findById(request.agendaId())
                .orElseThrow(() -> new MeetingHandler(ErrorStatus.MEETING_NOT_FOUND));
        AgendaDetail detail = AgendaDetail.builder()
                .content(request.content())
                .agenda(agenda)
                .build();
        return agendaDetailRepository.save(detail).getId();
    }

    @Override
    @Transactional
    public void update(Long agendaDetailId, AgendaDetailUpdateRequestDTO request) {
        AgendaDetail detail = agendaDetailRepository.findById(agendaDetailId)
                .orElseThrow(() -> new MeetingHandler(ErrorStatus.MEETING_NOT_FOUND));
        detail.setContent(request.content());
    }

    @Override
    public void delete(Long agendaDetailId) {
        AgendaDetail detail = agendaDetailRepository.findById(agendaDetailId)
                .orElseThrow(() -> new MeetingHandler(ErrorStatus.MEETING_NOT_FOUND));
        agendaDetailRepository.delete(detail);
    }
}
