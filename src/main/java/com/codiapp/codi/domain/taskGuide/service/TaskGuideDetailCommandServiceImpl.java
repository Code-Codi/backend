package com.codiapp.codi.domain.taskGuide.service;

import com.codiapp.codi.domain.taskGuide.controller.TaskGuideDetailController;
import com.codiapp.codi.domain.taskGuide.converter.TaskGuideConverter;
import com.codiapp.codi.domain.taskGuide.dto.request.TaskGuideDetailCreateRequestDTO;
import com.codiapp.codi.domain.taskGuide.entity.TaskGuide;
import com.codiapp.codi.domain.taskGuide.entity.TaskGuideDetail;
import com.codiapp.codi.domain.taskGuide.repository.TaskGuideDetailRepository;
import com.codiapp.codi.domain.taskGuide.repository.TaskGuideRepository;
import com.codiapp.codi.global.apiPayload.code.status.ErrorStatus;
import com.codiapp.codi.global.apiPayload.exception.handler.TaskGuideHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskGuideDetailCommandServiceImpl implements TaskGuideDetailCommandService {
    private final TaskGuideDetailRepository guideDetailRepository;
    private final TaskGuideRepository taskGuideRepository;

    public @Override Long createTaskGuideDetail(TaskGuideDetailCreateRequestDTO request) {
        TaskGuide taskGuide = taskGuideRepository.findById(request.taskGuideId())
                .orElseThrow(() -> new TaskGuideHandler(ErrorStatus.TASK_GUIDE_NOT_FOUND));

        TaskGuideDetail detail = TaskGuideConverter.toTaskGuideDetail(request, taskGuide);
        return guideDetailRepository.save(detail).getId();
    }
}
