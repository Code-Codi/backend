package com.codiapp.codi.domain.meeting.controller;

import com.codiapp.codi.domain.meeting.dto.request.AgendaCreateRequestDTO;
import com.codiapp.codi.domain.meeting.dto.request.AgendaDetailCreateRequestDTO;
import com.codiapp.codi.domain.meeting.dto.request.AgendaDetailUpdateRequestDTO;
import com.codiapp.codi.domain.meeting.dto.request.AgendaUpdateRequestDTO;
import com.codiapp.codi.domain.meeting.dto.request.DecisionCreateRequestDTO;
import com.codiapp.codi.domain.meeting.dto.request.DecisionUpdateRequestDTO;
import com.codiapp.codi.domain.meeting.service.AgendaCommandService;
import com.codiapp.codi.domain.meeting.service.AgendaDetailCommandService;
import com.codiapp.codi.domain.meeting.service.DecisionCommandService;
import com.codiapp.codi.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/meeting/item")
public class MeetingSubItemController {

    private final AgendaCommandService agendaCommandService;
    private final AgendaDetailCommandService agendaDetailCommandService;
    private final DecisionCommandService decisionCommandService;

    //  Agenda
    @PostMapping("/agenda")
    public ResponseEntity<ApiResponse<Long>> createAgenda(@RequestBody AgendaCreateRequestDTO request) {
        Long agendaId = agendaCommandService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.onSuccess(agendaId));
    }

    @PatchMapping("/agenda/{agendaId}")
    public ResponseEntity<ApiResponse<Void>> updateAgenda(@PathVariable Long agendaId, @RequestBody AgendaUpdateRequestDTO request) {
        agendaCommandService.update(agendaId, request);
        return ResponseEntity.ok(ApiResponse.onSuccess(null));
    }

    @DeleteMapping("/agenda/{agendaId}")
    public ResponseEntity<ApiResponse<Void>> deleteAgenda(@PathVariable Long agendaId) {
        agendaCommandService.delete(agendaId);
        return ResponseEntity.ok(ApiResponse.onSuccess(null));
    }

    //  AgendaDetail
    @PostMapping("/agenda-detail")
    public ResponseEntity<ApiResponse<Long>> createAgendaDetail(@RequestBody AgendaDetailCreateRequestDTO request) {
        Long detailId = agendaDetailCommandService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.onSuccess(detailId));
    }

    @PatchMapping("/agenda-detail/{agendaDetailId}")
    public ResponseEntity<ApiResponse<Void>> updateAgendaDetail(@PathVariable Long agendaDetailId, @RequestBody AgendaDetailUpdateRequestDTO request) {
        agendaDetailCommandService.update(agendaDetailId, request);
        return ResponseEntity.ok(ApiResponse.onSuccess(null));
    }

    @DeleteMapping("/agenda-detail/{agendaDetailId}")
    public ResponseEntity<ApiResponse<Void>> deleteAgendaDetail(@PathVariable Long agendaDetailId) {
        agendaDetailCommandService.delete(agendaDetailId);
        return ResponseEntity.ok(ApiResponse.onSuccess(null));
    }

    //  Decision
    @PostMapping("/decision")
    public ResponseEntity<ApiResponse<Long>> createDecision(@RequestBody DecisionCreateRequestDTO request) {
        Long decisionId = decisionCommandService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.onSuccess(decisionId));
    }

    @PatchMapping("/decision/{decisionId}")
    public ResponseEntity<ApiResponse<Void>> updateDecision(@PathVariable Long decisionId, @RequestBody DecisionUpdateRequestDTO request) {
        decisionCommandService.update(decisionId, request);
        return ResponseEntity.ok(ApiResponse.onSuccess(null));
    }

    @DeleteMapping("/decision/{decisionId}")
    public ResponseEntity<ApiResponse<Void>> deleteDecision(@PathVariable Long decisionId) {
        decisionCommandService.delete(decisionId);
        return ResponseEntity.ok(ApiResponse.onSuccess(null));
    }
}
