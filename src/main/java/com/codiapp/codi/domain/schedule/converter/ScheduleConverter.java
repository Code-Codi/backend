package com.codiapp.codi.domain.schedule.converter;

import com.codiapp.codi.domain.schedule.dto.ScheduleCreateRequestDTO;
import com.codiapp.codi.domain.schedule.dto.ScheduleCreateResponseDTO;
import com.codiapp.codi.domain.schedule.dto.ScheduleDetailResponseDTO;
import com.codiapp.codi.domain.schedule.entity.Schedule;
import com.codiapp.codi.domain.team.entity.Team;

import java.time.LocalDateTime;

public class ScheduleConverter {
    public static ScheduleDetailResponseDTO toScheduleDetailResponseDTO(Schedule schedule) {
        return ScheduleDetailResponseDTO.builder()
                .id(schedule.getId())
                .title(schedule.getTitle())
                .startDate(schedule.getStartDate())
                .endDate(schedule.getEndDate())
                .content(schedule.getContent())
                .build();
    }

    public static Schedule toSchedule(ScheduleCreateRequestDTO request, Team team) {
        return Schedule.builder()
                .team(team)
                .title(request.title())
                .startDate(request.startDate())
                .endDate(request.endDate())
                .content(request.content())
                .build();
    }

    public static ScheduleCreateResponseDTO toScheduleCreateResponseDTO(Schedule schedule) {
        return ScheduleCreateResponseDTO.builder()
                .id(schedule.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
