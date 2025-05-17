package com.codiapp.codi.domain.task.service;

import com.codiapp.codi.domain.task.dto.request.TaskCreateRequestDTO;
import com.codiapp.codi.domain.task.dto.request.TaskUpdateRequestDTO;

public interface TaskCommandService {
    Long createTask(TaskCreateRequestDTO request);
    void updateTask(Long taskId, TaskUpdateRequestDTO request);
    void deleteTask(Long taskId);
}
