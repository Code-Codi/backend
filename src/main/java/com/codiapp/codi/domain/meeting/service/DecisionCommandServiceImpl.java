package com.codiapp.codi.domain.meeting.service;

import com.codiapp.codi.domain.meeting.dto.request.DecisionCreateRequestDTO;
import com.codiapp.codi.domain.meeting.dto.request.DecisionUpdateRequestDTO;
import com.codiapp.codi.domain.meeting.entity.Decision;
import com.codiapp.codi.domain.meeting.entity.Meeting;
import com.codiapp.codi.domain.meeting.repository.DecisionRepository;
import com.codiapp.codi.domain.meeting.repository.MeetingRepository;
import com.codiapp.codi.global.apiPayload.code.status.ErrorStatus;
import com.codiapp.codi.global.apiPayload.exception.handler.MeetingHandler;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DecisionCommandServiceImpl implements DecisionCommandService {

    private final DecisionRepository decisionRepository;
    private final MeetingRepository meetingRepository;

    @Override
    public Long create(DecisionCreateRequestDTO request) {
        Meeting meeting = meetingRepository.findById(request.meetingId())
                .orElseThrow(() -> new MeetingHandler(ErrorStatus.MEETING_NOT_FOUND));
        Decision decision = Decision.builder()
                .content(request.content())
                .meeting(meeting)
                .build();
        return decisionRepository.save(decision).getId();
    }

    @Override
    @Transactional
    public void update(Long decisionId, DecisionUpdateRequestDTO request) {
        Decision decision = decisionRepository.findById(decisionId)
                .orElseThrow(() -> new MeetingHandler(ErrorStatus.MEETING_NOT_FOUND));
        decision.setContent(request.content());
    }

    @Override
    public void delete(Long decisionId) {
        Decision decision = decisionRepository.findById(decisionId)
                .orElseThrow(() -> new MeetingHandler(ErrorStatus.MEETING_NOT_FOUND));
        decisionRepository.delete(decision);
    }
}
