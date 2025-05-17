package com.codiapp.codi.domain.task.repository;

import com.codiapp.codi.domain.task.entity.TaskDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskDetailRepository extends JpaRepository<TaskDetail, Long> {

    // 특정 Task(과제)에 속한 세부 항목들 조회
    List<TaskDetail> findByTaskId(Long taskId);

    // 특정 Task를 삭제할 때 모든 세부 항목도 함께 삭제하고 싶은 경우 명시적으로 삭제
    void deleteByTaskId(Long taskId);
}
