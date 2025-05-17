package com.codiapp.codi.domain.schedule.converter;

import com.codiapp.codi.domain.schedule.dto.ScheduleDetailResponseDTO;
import com.codiapp.codi.domain.schedule.entity.Schedule;

public class ScheduleConverter {
    public static ScheduleDetailResponseDTO scheduleDetailResponseDTO(Schedule schedule) {
        return ScheduleDetailResponseDTO.builder()
                .id(schedule.getId())
                .title(schedule.getTitle())
                .startDate(schedule.getStartDate())
                .endDate(schedule.getEndDate())
                .content(schedule.getContent())
                .build();
    }
}
