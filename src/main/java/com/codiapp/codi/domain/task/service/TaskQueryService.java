package com.codiapp.codi.domain.task.service;

import com.codiapp.codi.domain.task.dto.response.FinalTaskListResponseDTO;
import com.codiapp.codi.domain.task.dto.response.FinalTaskResponseDTO;
import com.codiapp.codi.domain.task.dto.response.FinalTeamListResponseDTO;
import com.codiapp.codi.domain.task.dto.response.TaskListResponseDTO;
import com.codiapp.codi.domain.task.dto.response.TaskResponseDTO;
import com.codiapp.codi.domain.task.entity.TaskStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TaskQueryService {
    TaskResponseDTO getTask(Long taskId);
    Page<FinalTaskListResponseDTO> getAllTasks(Long teamId, Pageable pageable);
    FinalTaskResponseDTO getFinalTask(Long taskId);
    List<FinalTeamListResponseDTO> getTeamTasksByStatus(Long courseId, Long teamId, TaskStatus status);

}
