package com.codiapp.codi.domain.schedule.service;

import com.codiapp.codi.domain.schedule.entity.Schedule;

public interface ScheduleQueryService {
    Schedule getSchedule(Long scheduleId);
}
