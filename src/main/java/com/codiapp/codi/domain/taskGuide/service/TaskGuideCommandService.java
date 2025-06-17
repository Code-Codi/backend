package com.codiapp.codi.domain.taskGuide.service;

import com.codiapp.codi.domain.taskGuide.dto.request.TaskGuideCreateRequestDTO;

public interface TaskGuideCommandService {
    Long createGuideTask(TaskGuideCreateRequestDTO request);
}
