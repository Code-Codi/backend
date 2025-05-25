package com.codiapp.codi.domain.task.service;

import com.codiapp.codi.domain.task.dto.response.TaskListResponseDTO;
import com.codiapp.codi.domain.task.dto.response.TaskResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TaskQueryService {
    TaskResponseDTO getTask(Long taskId);
    Page<TaskListResponseDTO> getAllTasks(Pageable pageable);
}
