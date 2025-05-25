package com.codiapp.codi.domain.task.service;

import com.codiapp.codi.domain.task.converter.TaskConverter;
import com.codiapp.codi.domain.task.dto.response.TaskListResponseDTO;
import com.codiapp.codi.domain.task.dto.response.TaskResponseDTO;
import com.codiapp.codi.domain.task.repository.TaskRepository;
import com.codiapp.codi.global.apiPayload.code.status.ErrorStatus;
import com.codiapp.codi.global.apiPayload.exception.handler.TaskHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.codiapp.codi.domain.task.entity.Task;
@Service
@RequiredArgsConstructor
public class TaskQueryServiceImpl implements TaskQueryService {

    private final TaskRepository taskRepository;

    @Override
    public TaskResponseDTO getTask(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskHandler(ErrorStatus.TASK_NOT_FOUND));
        return TaskConverter.toTaskResponseDTO(task);
    }

    @Override
    public Page<TaskListResponseDTO> getAllTasks(Pageable pageable) {
        return taskRepository.findAll(pageable)
                .map(TaskConverter::toTaskListResponseDTO);
    }
}
