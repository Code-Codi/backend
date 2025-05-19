package com.codiapp.codi.domain.task.service;

import com.codiapp.codi.domain.task.converter.TaskConverter;
import com.codiapp.codi.domain.task.dto.request.TaskCreateRequestDTO;
import com.codiapp.codi.domain.task.dto.request.TaskUpdateRequestDTO;
import com.codiapp.codi.domain.task.entity.Task;
import com.codiapp.codi.domain.task.repository.TaskRepository;
import com.codiapp.codi.domain.team.entity.Team;
import com.codiapp.codi.domain.team.repository.TeamRepository;
import com.codiapp.codi.global.apiPayload.code.status.ErrorStatus;
import com.codiapp.codi.global.apiPayload.exception.handler.TaskHandler;
import com.codiapp.codi.global.apiPayload.exception.handler.TeamHandler;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskCommandServiceImpl implements TaskCommandService {

    private final TaskRepository taskRepository;
    private final TeamRepository teamRepository;

    @Override
    public Long createTask(TaskCreateRequestDTO request) {
        Team team = teamRepository.findById(request.teamId())
                .orElseThrow(() -> new TeamHandler(ErrorStatus.TEAM_NOT_FOUND));

        Task task = TaskConverter.toTask(request, team);
        return taskRepository.save(task).getId();
    }

    @Override
    @Transactional
    public void updateTask(Long taskId, TaskUpdateRequestDTO request) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskHandler(ErrorStatus.TASK_NOT_FOUND));

        TaskConverter.updateTask(task, request);
    }

    @Override
    public void deleteTask(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskHandler(ErrorStatus.TASK_NOT_FOUND));

        taskRepository.delete(task);
    }
}
