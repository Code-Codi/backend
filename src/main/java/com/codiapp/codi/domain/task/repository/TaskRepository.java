package com.codiapp.codi.domain.task.repository;

import com.codiapp.codi.domain.task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    // 특정 팀(teamId)에 속한 모든 Task 목록 조회
    List<Task> findByTeamId(Long teamId);
}
