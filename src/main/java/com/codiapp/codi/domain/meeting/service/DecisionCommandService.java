package com.codiapp.codi.domain.meeting.service;

import com.codiapp.codi.domain.meeting.dto.request.DecisionCreateRequestDTO;
import com.codiapp.codi.domain.meeting.dto.request.DecisionUpdateRequestDTO;

public interface DecisionCommandService {
    Long create(DecisionCreateRequestDTO request);
    void update(Long decisionId, DecisionUpdateRequestDTO request);
    void delete(Long decisionId);
}
