package com.codiapp.codi.domain.schedule.controller;

import com.codiapp.codi.domain.schedule.converter.ScheduleConverter;
import com.codiapp.codi.domain.schedule.dto.ScheduleDetailResponseDTO;
import com.codiapp.codi.domain.schedule.service.ScheduleQueryService;
import com.codiapp.codi.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class ScheduleController {
    private final ScheduleQueryService scheduleQueryService;

    @Operation(summary = "스케줄 상세 조회", description = "스케줄의 상세 정보를 조회합니다.")
    @GetMapping("/{scheduleId}")
    @Parameters({
            @Parameter(name = "scheduleId", description = "스케줄 ID(PK)")
    })
    public ApiResponse<ScheduleDetailResponseDTO> getSchedule(@PathVariable Long scheduleId) {
        return ApiResponse.onSuccess(ScheduleConverter.scheduleDetailResponseDTO(scheduleQueryService.getSchedule(scheduleId)));
    }
}
