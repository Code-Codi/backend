package com.codiapp.codi.domain.taskGuide.service;

import com.codiapp.codi.domain.taskGuide.dto.request.TaskGuideCreateRequestDTO;
import com.codiapp.codi.domain.taskGuide.dto.request.TaskGuideUpdateRequestDTO;
import com.codiapp.codi.domain.taskGuide.entity.TaskGuide;

public interface TaskGuideCommandService {
    Long createTaskGuide(TaskGuideCreateRequestDTO request);
    void updateTaskGuide(Long id, TaskGuideUpdateRequestDTO request);
    void deleteTaskGuide(Long id);
    void createEmptyTasksForTeams(TaskGuide guide);
    void generateTasks(Long taskGuideId);
}
