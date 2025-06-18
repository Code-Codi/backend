package com.codiapp.codi.domain.task.repository;

import com.codiapp.codi.domain.task.entity.Task;
import com.codiapp.codi.domain.task.entity.TaskStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    // 특정 팀(teamId)에 속한 모든 Task 목록 조회
    Page<Task> findAllByTeamId(Long teamId, Pageable pageable);
    Page<Task> findByTaskGuide_Course_IdAndTeamIdAndStatus(Long courseId, Long teamId, TaskStatus status, Pageable pageable);

}
