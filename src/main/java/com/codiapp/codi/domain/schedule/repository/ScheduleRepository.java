package com.codiapp.codi.domain.schedule.repository;

import com.codiapp.codi.domain.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query("SELECT s FROM Schedule s " +
            "WHERE (EXTRACT(MONTH FROM s.startDate) = :month AND EXTRACT(YEAR FROM s.startDate) = :year) " +
            "OR (EXTRACT(MONTH FROM s.endDate) = :month AND EXTRACT(YEAR FROM s.endDate) = :year) " +
            "OR (s.startDate < TO_DATE(:year || '-' || :month || '-01', 'YYYY-MM-DD') " +
            "AND s.endDate > LAST_DAY(TO_DATE(:year || '-' || :month || '-01', 'YYYY-MM-DD'))) " +
            "ORDER BY EXTRACT(MONTH FROM s.startDate) ASC, s.createdAt ASC")
    List<Schedule> findSchedulesByMonthAndYear(@Param("month") int month, @Param("year") int year);
}
