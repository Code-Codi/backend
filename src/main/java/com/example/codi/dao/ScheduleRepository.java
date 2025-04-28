package com.example.codi.dao;

import java.util.List;

public interface ScheduleRepository {
    Long insertSchedule(Schedule schedule);
    Schedule findScheduleById(Long scheduleId);
     List<Schedule> findSchedulesByTeamId(Long teamId); // 팀별로 스케쥴 관리
    void updateSchedule(Schedule schedule);
    void deleteSchedule(Long scheduleId);
}