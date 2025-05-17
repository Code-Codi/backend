package com.codiapp.codi.domain.meeting.controller;

import com.codiapp.codi.domain.meeting.dto.request.MeetingCreateRequestDTO;
import com.codiapp.codi.domain.meeting.dto.response.MeetingDetailResponseDTO;
import com.codiapp.codi.domain.meeting.entity.Meeting;
import com.codiapp.codi.domain.meeting.service.MeetingCommandService;
import com.codiapp.codi.domain.meeting.service.MeetingQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/meeting")
@RequiredArgsConstructor
@Tag(name = "회의록 API", description = "회의록 등록 및 조회")
public class MeetingController {

    private final MeetingCommandService meetingCommandService;
    private final MeetingQueryService meetingQueryService;

    @PostMapping
    @Operation(summary = "회의록 생성", description = "회의 제목, 일시, 장소, 안건, 결정사항을 포함한 회의록을 생성합니다.")
    public ResponseEntity<Long> createMeeting(@RequestBody MeetingCreateRequestDTO request) {
        Meeting created = meetingCommandService.createMeeting(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created.getId());
    }

    @GetMapping("/{id}")
    @Operation(summary = "회의록 단일 조회", description = "회의록 ID를 이용해 회의록 상세 내용을 조회합니다.")
    public ResponseEntity<MeetingDetailResponseDTO> getMeeting(@Parameter(description = "회의록 ID") @PathVariable Long id) {
        MeetingDetailResponseDTO dto = meetingQueryService.getMeetingDetail(id);
        return ResponseEntity.ok(dto);
    }
}
