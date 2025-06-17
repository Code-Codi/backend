package com.codiapp.codi.domain.taskGuide.converter;

import com.codiapp.codi.domain.taskGuide.dto.response.TaskGuideDetailResponseDTO;
import com.codiapp.codi.domain.taskGuide.dto.response.TaskGuideResponseDTO;
import com.codiapp.codi.domain.taskGuide.entity.TaskGuide;

import java.util.List;
import java.util.stream.Collectors;

public class TaskGuideConverter {

    public static TaskGuideResponseDTO toTaskGuideResponeDTO(TaskGuide taskGuide) {
        List<TaskGuideDetailResponseDTO> detailDTOs = taskGuide.getDetails().stream()
                .map(d-> new TaskGuideDetailResponseDTO(d.getId(), d.getDetailTitle(), d.getDescription()))
                .collect(Collectors.toList());

        return new TaskGuideResponseDTO(
                taskGuide.getId(),
                taskGuide.getTitle(),
                taskGuide.getDueDate(),
                taskGuide.getCreatedAt(),
                detailDTOs
        );
    }
}
