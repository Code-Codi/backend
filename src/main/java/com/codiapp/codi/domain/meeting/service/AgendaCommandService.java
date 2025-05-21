package com.codiapp.codi.domain.meeting.service;

import com.codiapp.codi.domain.meeting.dto.request.AgendaCreateRequestDTO;
import com.codiapp.codi.domain.meeting.dto.request.AgendaUpdateRequestDTO;

public interface AgendaCommandService {
    Long create(AgendaCreateRequestDTO request);
    void update(Long agendaId, AgendaUpdateRequestDTO request);
    void delete(Long agendaId);
}
