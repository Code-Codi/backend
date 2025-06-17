package com.codiapp.codi.domain.taskGuide.service;

import com.codiapp.codi.domain.taskGuide.dto.request.TaskGuideDetailCreateRequestDTO;

public interface TaskGuideDetailCommandService {
    Long createTaskGuideDetail(TaskGuideDetailCreateRequestDTO request);
}
