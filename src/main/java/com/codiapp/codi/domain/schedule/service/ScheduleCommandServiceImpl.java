package com.codiapp.codi.domain.schedule.service;

import com.codiapp.codi.domain.schedule.converter.ScheduleConverter;
import com.codiapp.codi.domain.schedule.dto.ScheduleCreateRequestDTO;
import com.codiapp.codi.domain.schedule.entity.Schedule;
import com.codiapp.codi.domain.schedule.repository.ScheduleRepository;
import com.codiapp.codi.domain.team.entity.Team;
import com.codiapp.codi.domain.team.repository.TeamRepository;
import com.codiapp.codi.global.apiPayload.code.status.ErrorStatus;
import com.codiapp.codi.global.apiPayload.exception.handler.TeamHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleCommandServiceImpl implements ScheduleCommandService {
    private final ScheduleRepository scheduleRepository;
    private final TeamRepository teamRepository;

    @Override
    public Schedule createSchedule(ScheduleCreateRequestDTO request) {
        Team team = teamRepository.findById(request.teamId()).orElseThrow(() -> new TeamHandler(ErrorStatus.TEAM_NOT_FOUND));
        return scheduleRepository.save(ScheduleConverter.toSchedule(request, team));
    }
}
