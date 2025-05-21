package com.codiapp.codi.domain.meeting.service;

import com.codiapp.codi.domain.meeting.dto.request.AgendaDetailCreateRequestDTO;
import com.codiapp.codi.domain.meeting.dto.request.AgendaDetailUpdateRequestDTO;

public interface AgendaDetailCommandService {
    Long create(AgendaDetailCreateRequestDTO request);
    void update(Long agendaDetailId, AgendaDetailUpdateRequestDTO request);
    void delete(Long agendaDetailId);
}
