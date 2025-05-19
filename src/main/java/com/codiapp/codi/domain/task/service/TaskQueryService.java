package com.codiapp.codi.domain.task.service;

import com.codiapp.codi.domain.task.dto.response.TaskListResponseDTO;
import com.codiapp.codi.domain.task.dto.response.TaskResponseDTO;

import java.util.List;

public interface TaskQueryService {
    TaskResponseDTO getTask(Long taskId);
    List<TaskListResponseDTO> getTaskListByTeam(Long teamId);
}
