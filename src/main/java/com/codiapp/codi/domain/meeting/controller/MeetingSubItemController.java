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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
    @Operation(summary = "안건 생성", description = "회의 안건을 생성합니다.")
    @PostMapping("/agenda")
    public ResponseEntity<ApiResponse<Long>> createAgenda(@RequestBody AgendaCreateRequestDTO request) {
        Long agendaId = agendaCommandService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.onSuccess(agendaId));
    }

    @Operation(summary = "안건 수정", description = "지정된 ID의 회의 안건을 수정합니다.")
    @PatchMapping("/agenda/{agendaId}")
    public ResponseEntity<ApiResponse<Void>> updateAgenda(@Parameter(description = "수정할 안건 ID", example = "1")  @PathVariable Long agendaId, @RequestBody AgendaUpdateRequestDTO request) {
        agendaCommandService.update(agendaId, request);
        return ResponseEntity.ok(ApiResponse.onSuccess(null));
    }

    @Operation(summary = "안건 삭제", description = "지정된 ID의 회의 안건을 삭제합니다.")
    @DeleteMapping("/agenda/{agendaId}")
    public ResponseEntity<ApiResponse<Void>> deleteAgenda(
            @Parameter(description = "삭제할 안건 ID", example = "1")
            @PathVariable Long agendaId) {
        agendaCommandService.delete(agendaId);
        return ResponseEntity.ok(ApiResponse.onSuccess(null));
    }

    //  AgendaDetail
    @Operation(summary = "안건 세부 항목 생성", description = "회의 안건의 세부 항목을 생성합니다.")
    @PostMapping("/agenda-detail")
    public ResponseEntity<ApiResponse<Long>> createAgendaDetail(@RequestBody AgendaDetailCreateRequestDTO request) {
        Long detailId = agendaDetailCommandService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.onSuccess(detailId));
    }

    @Operation(summary = "안건 세부 항목 수정", description = "지정된 ID의 회의 안건 세부 항목을 수정합니다.")
    @PatchMapping("/agenda-detail/{agendaDetailId}")
    public ResponseEntity<ApiResponse<Void>> updateAgendaDetail(
            @Parameter(description = "수정할 안건 세부 항목 ID", example = "1")
            @PathVariable Long agendaDetailId, @RequestBody AgendaDetailUpdateRequestDTO request) {
        agendaDetailCommandService.update(agendaDetailId, request);
        return ResponseEntity.ok(ApiResponse.onSuccess(null));
    }

    @Operation(summary = "안건 세부 항목 삭제", description = "지정된 ID의 회의 안건 세부 항목을 삭제합니다.")
    @DeleteMapping("/agenda-detail/{agendaDetailId}")
    public ResponseEntity<ApiResponse<Void>> deleteAgendaDetail(
            @Parameter(description = "삭제할 안건 세부 항목 ID", example = "1")
            @PathVariable Long agendaDetailId) {
        agendaDetailCommandService.delete(agendaDetailId);
        return ResponseEntity.ok(ApiResponse.onSuccess(null));
    }

    //  Decision
    @Operation(summary = "결정 사항 생성", description = "회의 결정 사항을 생성합니다.")
    @PostMapping("/decision")
    public ResponseEntity<ApiResponse<Long>> createDecision(@RequestBody DecisionCreateRequestDTO request) {
        Long decisionId = decisionCommandService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.onSuccess(decisionId));
    }

    @Operation(summary = "결정 사항 수정", description = "지정된 ID의 회의 결정 사항을 수정합니다.")
    @PatchMapping("/decision/{decisionId}")
    public ResponseEntity<ApiResponse<Void>> updateDecision(
            @Parameter(description = "수정할 결정 사항 ID", example = "1")
            @PathVariable Long decisionId, @RequestBody DecisionUpdateRequestDTO request) {
        decisionCommandService.update(decisionId, request);
        return ResponseEntity.ok(ApiResponse.onSuccess(null));
    }

    @Operation(summary = "결정 사항 삭제", description = "지정된 ID의 회의 결정 사항을 삭제합니다.")
    @DeleteMapping("/decision/{decisionId}")
    public ResponseEntity<ApiResponse<Void>> deleteDecision(
            @Parameter(description = "삭제할 결정 사항 ID", example = "1")
            @PathVariable Long decisionId) {
        decisionCommandService.delete(decisionId);
        return ResponseEntity.ok(ApiResponse.onSuccess(null));
    }
}
