package com.codiapp.codi.domain.taskGuide.service;

import com.codiapp.codi.domain.taskGuide.dto.request.TaskGuideDetailCreateRequestDTO;
import com.codiapp.codi.domain.taskGuide.dto.request.TaskGuideDetailUpdateRequestDTO;

public interface TaskGuideDetailCommandService {
    Long createTaskGuideDetail(TaskGuideDetailCreateRequestDTO request);
    void updateTaskGuideDetail(Long id, TaskGuideDetailUpdateRequestDTO request);
    void deleteTaskGuideDetail(Long id);
}
