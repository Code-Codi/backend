package com.codiapp.codi.domain.task.service;

import com.codiapp.codi.domain.task.dto.request.TaskDetailCreateRequestDTO;
import com.codiapp.codi.domain.task.dto.request.TaskDetailUpdateRequestDTO;

public interface TaskDetailCommandService {
    Long createDetail(TaskDetailCreateRequestDTO request);
    void updateDetail(Long detailId, TaskDetailUpdateRequestDTO request);
    void deleteDetail(Long detailId);
}
