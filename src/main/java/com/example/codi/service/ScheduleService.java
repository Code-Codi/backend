package com.example.codi.service;
import java.util.List;


public interface ScheduleService {
    Long insertSchedule(Schedule schedule);
    Schedule findScheduleById(Long scheduleId);
    List<Schedule> findSchedulesByTeamId(Long teamId);
    void updateSchedule(Schedule schedule);
    void deleteSchedule(Long scheduleId);
}