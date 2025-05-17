package com.codiapp.codi.domain.schedule.repository;

import com.codiapp.codi.domain.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query("SELECT s FROM Schedule s " +
            //시작일이 해당 월에 포함되는 경우
            "WHERE (EXTRACT(MONTH FROM s.startDate) = :month AND EXTRACT(YEAR FROM s.startDate) = :year) " +
            // 종료일이 해당 월에 포함되는 경우
            "OR (EXTRACT(MONTH FROM s.endDate) = :month AND EXTRACT(YEAR FROM s.endDate) = :year) " +
            // 일정이 월 전체를 포함하는 경우
            "OR (s.startDate < TO_DATE(:year || '-' || :month || '-01', 'YYYY-MM-DD') " +
            "AND s.endDate > LAST_DAY(TO_DATE(:year || '-' || :month || '-01', 'YYYY-MM-DD')))")
    List<Schedule> findSchedulesByMonthAndYear(@Param("month") int month, @Param("year") int year);
}
