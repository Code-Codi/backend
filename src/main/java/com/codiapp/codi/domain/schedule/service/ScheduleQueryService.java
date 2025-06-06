package com.codiapp.codi.domain.schedule.service;

import com.codiapp.codi.domain.schedule.dto.response.ScheduleDetailResponseDTO;
import com.codiapp.codi.domain.schedule.entity.Schedule;

import java.util.List;

public interface ScheduleQueryService {
    Schedule getSchedule(Long scheduleId);
    List<ScheduleDetailResponseDTO> getSchedulesByMonthAndYearAndTeam(Long teamId, int year, int month);
}
