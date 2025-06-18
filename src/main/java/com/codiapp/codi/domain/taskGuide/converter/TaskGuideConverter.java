package com.codiapp.codi.domain.taskGuide.converter;

import com.codiapp.codi.domain.taskGuide.dto.request.TaskGuideCreateRequestDTO;
import com.codiapp.codi.domain.taskGuide.dto.request.TaskGuideDetailCreateRequestDTO;
import com.codiapp.codi.domain.taskGuide.dto.response.TaskGuideDetailResponseDTO;
import com.codiapp.codi.domain.taskGuide.dto.response.TaskGuideListResponseDTO;
import com.codiapp.codi.domain.taskGuide.dto.response.TaskGuideResponseDTO;
import com.codiapp.codi.domain.taskGuide.entity.TaskGuide;
import com.codiapp.codi.domain.taskGuide.entity.TaskGuideDetail;
import com.codiapp.codi.domain.course.entity.Course;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TaskGuideConverter {

    //단일 조회
    public static TaskGuideResponseDTO toTaskGuideResponeDTO(TaskGuide taskGuide) {
        List<TaskGuideDetailResponseDTO> detailDTOs = taskGuide.getDetails().stream()
                .map(d-> new TaskGuideDetailResponseDTO(d.getId(), d.getTitle(), d.getDescription()))
                .collect(Collectors.toList());

        return new TaskGuideResponseDTO(
                taskGuide.getId(),
                taskGuide.getTitle(),
                taskGuide.getDueDate(),
                taskGuide.getCreatedAt(),
                detailDTOs
        );
    }

    //dto-> entity
    public static TaskGuide toTaskGuide(TaskGuideCreateRequestDTO request, Course course) {
        TaskGuide taskGuide = TaskGuide.builder()
                .title(request.title())
                .dueDate(request.dueDate())
                .createdAt(LocalDateTime.now())
                .course(course)
                .build();
        return taskGuide;
    }

    public static TaskGuideDetail toTaskGuideDetail(TaskGuideDetailCreateRequestDTO request, TaskGuide taskGuide) {
        return TaskGuideDetail.builder()
                .title(request.title())
                .description(request.description())
                .taskGuide(taskGuide)
                .build();
    }

    public static TaskGuideListResponseDTO taskGuideListResponseDTO(TaskGuide taskGuide) {
        return new TaskGuideListResponseDTO(
                taskGuide.getId(),
                taskGuide.getTitle(),
                taskGuide.getDueDate(),
                taskGuide.getCreatedAt()
        );
    }
}
