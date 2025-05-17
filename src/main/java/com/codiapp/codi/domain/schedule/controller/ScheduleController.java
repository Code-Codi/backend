package com.codiapp.codi.domain.schedule.controller;

import com.codiapp.codi.domain.schedule.converter.ScheduleConverter;
import com.codiapp.codi.domain.schedule.dto.ScheduleCreateRequestDTO;
import com.codiapp.codi.domain.schedule.dto.ScheduleCreateResponseDTO;
import com.codiapp.codi.domain.schedule.dto.ScheduleDetailResponseDTO;
import com.codiapp.codi.domain.schedule.service.ScheduleCommandService;
import com.codiapp.codi.domain.schedule.service.ScheduleQueryService;
import com.codiapp.codi.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class ScheduleController {
    private final ScheduleQueryService scheduleQueryService;
    private final ScheduleCommandService scheduleCommandService;

    @Operation(summary = "스케줄 상세 조회", description = "스케줄의 상세 정보를 조회합니다.")
    @GetMapping("/{scheduleId}")
    @Parameters({
            @Parameter(name = "scheduleId", description = "스케줄 ID(PK)")
    })
    public ApiResponse<ScheduleDetailResponseDTO> getSchedule(@PathVariable Long scheduleId) {
        return ApiResponse.onSuccess(ScheduleConverter.toScheduleDetailResponseDTO(scheduleQueryService.getSchedule(scheduleId)));
    }

    @Operation(summary = "스케줄 등록", description = "스케줄을 등록합니다.")
    @PostMapping("")
    public ApiResponse<ScheduleCreateResponseDTO> createSchedule(@RequestBody ScheduleCreateRequestDTO request) {
        return ApiResponse.onSuccess(ScheduleConverter.toScheduleCreateResponseDTO(scheduleCommandService.createSchedule(request)));
    }
}
