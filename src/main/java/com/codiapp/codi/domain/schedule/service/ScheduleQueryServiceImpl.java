package com.codiapp.codi.domain.schedule.service;

import com.codiapp.codi.domain.schedule.entity.Schedule;
import com.codiapp.codi.domain.schedule.repository.ScheduleRepository;
import com.codiapp.codi.global.apiPayload.code.status.ErrorStatus;
import com.codiapp.codi.global.apiPayload.exception.handler.ScheduleHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleQueryServiceImpl implements ScheduleQueryService {
    private final ScheduleRepository scheduleRepository;

    @Override
    public Schedule getSchedule(Long scheduleId) {
        return scheduleRepository.findById(scheduleId).orElseThrow(() -> new ScheduleHandler(ErrorStatus.SCHEDULE_NOT_FOUND));
    }
}
