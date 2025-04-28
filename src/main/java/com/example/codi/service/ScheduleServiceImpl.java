package com.example.codi.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public Long insertSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule).getId();
    }

    @Override
    public Schedule findScheduleById(Long scheduleId) {
        return scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new RuntimeException("스케줄이 존재하지 않습니다."));
    }

    @Override
    public List<Schedule> findSchedulesByTeamId(Long teamId) {
        return scheduleRepository.findByTeamId(teamId);
    }

    @Override
    public void updateSchedule(Schedule schedule) {
        if (!scheduleRepository.existsById(schedule.getId())) {
            throw new RuntimeException("스케줄이 존재하지 않습니다.");
        }
        scheduleRepository.save(schedule);
    }

    @Override
    public void deleteSchedule(Long scheduleId) {
        if (!scheduleRepository.existsById(scheduleId)) {
            throw new RuntimeException("스케줄이 존재하지 않습니다.");
        }
        scheduleRepository.deleteById(scheduleId);
    }
}
