package com.codiapp.codi.domain.task.service;

import com.codiapp.codi.domain.task.dto.request.TaskDetailCreateRequestDTO;
import com.codiapp.codi.domain.task.dto.request.TaskDetailUpdateRequestDTO;
import com.codiapp.codi.domain.task.entity.Task;
import com.codiapp.codi.domain.task.entity.TaskDetail;
import com.codiapp.codi.domain.task.repository.TaskDetailRepository;
import com.codiapp.codi.domain.task.repository.TaskRepository;
import com.codiapp.codi.global.apiPayload.code.status.ErrorStatus;
import com.codiapp.codi.global.apiPayload.exception.handler.TaskHandler;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskDetailCommandServiceImpl implements TaskDetailCommandService {

    private final TaskRepository taskRepository;
    private final TaskDetailRepository taskDetailRepository;

    @Override
    public Long createDetail(TaskDetailCreateRequestDTO request) {
        Task task = taskRepository.findById(request.taskId())
                .orElseThrow(() -> new TaskHandler(ErrorStatus.TASK_NOT_FOUND));

        TaskDetail detail = TaskDetail.builder()
                .title(request.title())
                .content(request.content())
                .task(task)
                .build();

        return taskDetailRepository.save(detail).getId();
    }

    @Transactional
    @Override
    public void updateDetail(Long detailId, TaskDetailUpdateRequestDTO request) {
        TaskDetail detail = taskDetailRepository.findById(detailId)
                .orElseThrow(() -> new TaskHandler(ErrorStatus.TASK_DETAIL_NOT_FOUND));

        request.title().ifPresent(detail::updateTitle);
        request.content().ifPresent(detail::updateContent);
    }

    @Override
    public void deleteDetail(Long detailId) {
        TaskDetail detail = taskDetailRepository.findById(detailId)
                .orElseThrow(() -> new TaskHandler(ErrorStatus.TASK_DETAIL_NOT_FOUND));

        taskDetailRepository.delete(detail);
    }
}

