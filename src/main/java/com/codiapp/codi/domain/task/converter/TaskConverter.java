package com.codiapp.codi.domain.task.converter;

import com.codiapp.codi.domain.task.dto.request.*;
import com.codiapp.codi.domain.task.dto.response.*;
import com.codiapp.codi.domain.task.entity.*;
import com.codiapp.codi.domain.team.entity.Team;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskConverter {

    // Create DTO → Task Entity
    public static Task toTask(TaskCreateRequestDTO request, Team team) {
        Task task = Task.builder()
                .status(request.status())
                .taskDate(request.taskDate())
                .team(team)
                .build();
        return task;
    }

    //final 단일 조회
    public static FinalTaskResponseDTO toFinalTaskResponseDTO(Task task) {
        List<FinalDetailResponseDTO> detailDTOs = task.getDetails().stream()
                .map(detail -> {
                    var guideDetail = detail.getTaskGuideDetail();
                    return new FinalDetailResponseDTO(
                            detail.getId(),
                            detail.getContent(),
                            guideDetail.getId(),
                            guideDetail.getTitle(),
                            guideDetail.getDescription()
                    );
                })
                .collect(Collectors.toList());

        return new FinalTaskResponseDTO(
                task.getId(),
                task.getTeam().getName(),
                task.getTaskDate(),
                task.getTaskGuide().getId(),
                task.getTaskGuide().getTitle(),
                task.getTaskGuide().getDueDate(),
                task.getTaskGuide().getCreatedAt(),
                detailDTOs
        );
    }

    public static FinalTaskListResponseDTO toFinalTaskListResponseDTO (Task task) {
        return new FinalTaskListResponseDTO(
                task.getId(),
                task.getStatus(),
                task.getTaskGuide().getId(),
                task.getTaskGuide().getTitle(),
                task.getTaskGuide().getDueDate(),
                task.getTaskGuide().getCreatedAt()
        );
    }


    // Task Entity → TaskResponseDTO (단건 상세)
    public static TaskResponseDTO toTaskResponseDTO(Task task) {
        List<TaskDetailResponseDTO> detailDTOs = task.getDetails().stream()
                .map(d -> new TaskDetailResponseDTO(d.getId(), d.getContent()))
                .collect(Collectors.toList());

        return new TaskResponseDTO(
                task.getId(),
                task.getStatus(),
                task.getTaskDate(),
                detailDTOs
        );
    }

    // Task Entity → TaskListResponseDTO (목록용)
    public static TaskListResponseDTO toTaskListResponseDTO(Task task) {
        return new TaskListResponseDTO(
                task.getId(),
                task.getStatus(),
                task.getTaskDate()
        );
    }

    //final 기능에서 update
    public static void applyFinalTaskUpdate(Task task, FinalTaskUpdateRequestDTO dto) {
        Map<Long, String> contentMap = dto.details().stream()
                .collect(Collectors.toMap(FinalDetailUpdateRequestDTO::taskDetailId, FinalDetailUpdateRequestDTO::content));

        for (TaskDetail detail : task.getDetails()) {
            if (contentMap.containsKey(detail.getId())) {
                detail.updateContent(contentMap.get(detail.getId()));
            }
        }
    }
}
