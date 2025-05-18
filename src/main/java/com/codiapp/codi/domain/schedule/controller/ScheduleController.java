package com.codiapp.codi.domain.schedule.controller;

import com.codiapp.codi.domain.schedule.converter.ScheduleConverter;
import com.codiapp.codi.domain.schedule.dto.request.ScheduleCreateRequestDTO;
import com.codiapp.codi.domain.schedule.dto.request.ScheduleUpdateRequestDTO;
import com.codiapp.codi.domain.schedule.dto.response.ScheduleCreateResponseDTO;
import com.codiapp.codi.domain.schedule.dto.response.ScheduleDetailResponseDTO;
import com.codiapp.codi.domain.schedule.dto.response.ScheduleUpdateResponseDTO;
import com.codiapp.codi.domain.schedule.service.ScheduleCommandService;
import com.codiapp.codi.domain.schedule.service.ScheduleQueryService;
import com.codiapp.codi.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Operation(summary = "스케줄 수정", description = "스케줄의 상세 정보를 수정합니다.")
    @PatchMapping("/{scheduleId}")
    @Parameters({
            @Parameter(name = "scheduleId", description = "스케줄 ID(PK)")
    })
    public ApiResponse<ScheduleUpdateResponseDTO> updateSchedule(@PathVariable Long scheduleId, @RequestBody ScheduleUpdateRequestDTO request) {
        return ApiResponse.onSuccess(ScheduleConverter.toScheduleUpdateResponseDTO(scheduleCommandService.updateSchedule(scheduleId, request)));
    }

    @Operation(summary = "스케줄 삭제", description = "스케줄을 삭제합니다.")
    @DeleteMapping("/{scheduleId}")
    @Parameters({
            @Parameter(name = "scheduleId", description = "스케줄 ID(PK)")
    })
    public ApiResponse<String> deleteSchedule(@PathVariable Long scheduleId) {
        scheduleCommandService.deleteSchedule(scheduleId);
        return ApiResponse.onSuccess("스케줄이 성공적으로 삭제되었습니다.");
    }

    @Operation(summary = "스케줄 목록 조회", description = "선택한 연도와 월에 해당하는 스케줄 목록을 조회합니다.")
    @GetMapping("")
    @Parameters({
            @Parameter(name = "year", description = "조회할 연도"),
            @Parameter(name = "month", description = "조회할 월")
    })
    public ApiResponse<List<ScheduleDetailResponseDTO>> getSchedulesByMonthAndYear(@RequestParam int year, @RequestParam int month) {
        return ApiResponse.onSuccess(scheduleQueryService.getSchedulesByMonthAndYear(year, month));
    }
}
