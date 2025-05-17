package com.codiapp.codi.domain.schedule.service;

import com.codiapp.codi.domain.schedule.dto.request.ScheduleCreateRequestDTO;
import com.codiapp.codi.domain.schedule.dto.request.ScheduleUpdateRequestDTO;
import com.codiapp.codi.domain.schedule.entity.Schedule;

public interface ScheduleCommandService {
    Schedule createSchedule(ScheduleCreateRequestDTO request);
    Schedule updateSchedule(ScheduleUpdateRequestDTO request);
    void deleteSchedule(Long id);
}
