package com.codiapp.codi.domain.schedule.repository;

import com.codiapp.codi.domain.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
