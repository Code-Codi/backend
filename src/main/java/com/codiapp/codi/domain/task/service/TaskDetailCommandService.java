package com.codiapp.codi.domain.task.service;

import com.codiapp.codi.domain.task.dto.request.TaskDetailCreateRequestDTO;
import com.codiapp.codi.domain.task.dto.request.BriefUpdateRequestDTO;

public interface TaskDetailCommandService {
    Long createDetail(TaskDetailCreateRequestDTO request);
    void updateDetail(Long detailId, BriefUpdateRequestDTO request);
    void deleteDetail(Long detailId);
}
