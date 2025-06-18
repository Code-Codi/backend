package com.codiapp.codi.domain.taskGuide.repository;

import com.codiapp.codi.domain.taskGuide.entity.TaskGuide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskGuideRepository extends JpaRepository<TaskGuide, Long> {
}
