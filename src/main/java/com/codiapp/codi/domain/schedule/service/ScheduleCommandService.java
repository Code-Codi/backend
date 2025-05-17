package com.codiapp.codi.domain.schedule.service;

import com.codiapp.codi.domain.schedule.dto.ScheduleCreateRequestDTO;
import com.codiapp.codi.domain.schedule.entity.Schedule;

public interface ScheduleCommandService {
    Schedule createSchedule(ScheduleCreateRequestDTO request);
}
