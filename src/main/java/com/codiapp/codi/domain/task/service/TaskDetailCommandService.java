package com.codiapp.codi.domain.task.service;

import com.codiapp.codi.domain.task.dto.request.TaskDetailCreateRequestDTO;
import com.codiapp.codi.domain.task.dto.request.TaskDeatailUpdateRequestDTO;

public interface TaskDetailCommandService {
    Long createDetail(TaskDetailCreateRequestDTO request);
    void updateDetail(Long detailId, TaskDeatailUpdateRequestDTO request);
    void deleteDetail(Long detailId);
}
