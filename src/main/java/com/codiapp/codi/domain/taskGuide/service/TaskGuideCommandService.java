package com.codiapp.codi.domain.taskGuide.service;

import com.codiapp.codi.domain.taskGuide.dto.request.TaskGuideCreateRequestDTO;
import com.codiapp.codi.domain.taskGuide.dto.request.TaskGuideUpdateRequestDTO;

public interface TaskGuideCommandService {
    Long createTaskGuide(TaskGuideCreateRequestDTO request);
    void updateTaskGuide(Long id, TaskGuideUpdateRequestDTO request);
    void deleteTaskGuide(Long id);
}
