package com.codiapp.codi.domain.task.converter;

import com.codiapp.codi.domain.task.dto.request.*;
import com.codiapp.codi.domain.task.dto.response.*;
import com.codiapp.codi.domain.task.entity.*;
import com.codiapp.codi.domain.team.entity.Team;

import java.util.List;
import java.util.stream.Collectors;

public class TaskConverter {

    // Create DTO → Task Entity
    public static Task toTask(TaskCreateRequestDTO request, Team team) {
        Task task = Task.builder()
                .title(request.title())
                .status(request.status())
                .taskDate(request.taskDate())
                .team(team)
                .build();
        return task;
    }

    // Update DTO → Task Entity 내부 변경 (엔티티 내부에서 직접 update 메서드 호출 전제로 작성)
    public static void updateTask(Task task, TaskUpdateRequestDTO request) {
        request.title().ifPresent(task::updateTitle);
        request.status().ifPresent(task::updateStatus);
        request.taskDate().ifPresent(task::updateTaskDate);
    }

    // Task Entity → TaskResponseDTO (단건 상세)
    public static TaskResponseDTO toTaskResponseDTO(Task task) {
        List<TaskDetailResponseDTO> detailDTOs = task.getDetails().stream()
                .map(d -> new TaskDetailResponseDTO(d.getId(), d.getTitle(), d.getContent()))
                .collect(Collectors.toList());

        return new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getStatus(),
                task.getTaskDate(),
                detailDTOs
        );
    }

    // Task Entity → TaskListResponseDTO (목록용)
    public static TaskListResponseDTO toTaskListResponseDTO(Task task) {
        return new TaskListResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getStatus(),
                task.getTaskDate()
        );
    }
}
