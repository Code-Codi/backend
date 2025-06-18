package com.codiapp.codi.domain.taskGuide.service;

import com.codiapp.codi.domain.taskGuide.converter.TaskGuideConverter;
import com.codiapp.codi.domain.taskGuide.dto.request.TaskGuideDetailCreateRequestDTO;
import com.codiapp.codi.domain.taskGuide.dto.request.TaskGuideDetailUpdateRequestDTO;
import com.codiapp.codi.domain.taskGuide.entity.TaskGuide;
import com.codiapp.codi.domain.taskGuide.entity.TaskGuideDetail;
import com.codiapp.codi.domain.taskGuide.repository.TaskGuideDetailRepository;
import com.codiapp.codi.domain.taskGuide.repository.TaskGuideRepository;
import com.codiapp.codi.global.apiPayload.code.status.ErrorStatus;
import com.codiapp.codi.global.apiPayload.exception.handler.TaskGuideHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TaskGuideDetailCommandServiceImpl implements TaskGuideDetailCommandService {
    private final TaskGuideDetailRepository taskGuideDetailRepository;
    private final TaskGuideRepository taskGuideRepository;

    @Override
    public Long createTaskGuideDetail(TaskGuideDetailCreateRequestDTO request) {
        TaskGuide taskGuide = taskGuideRepository.findById(request.taskGuideId())
                .orElseThrow(() -> new TaskGuideHandler(ErrorStatus.TaskGuide_NOT_FOUND));

        TaskGuideDetail detail = TaskGuideConverter.toTaskGuideDetail(request, taskGuide);
        return taskGuideDetailRepository.save(detail).getId();
    }

    @Override
    @Transactional
    public void updateTaskGuideDetail(Long id, TaskGuideDetailUpdateRequestDTO request) {
        TaskGuideDetail taskGuideDetail = taskGuideDetailRepository.findById(id)
                .orElseThrow(() -> new TaskGuideHandler(ErrorStatus.TaskGuide_DETAIL_NOT_FOUND));

        taskGuideDetail.updateDetail(request);
    }

    @Override
    public void deleteTaskGuideDetail(Long id) {
        TaskGuideDetail taskGuideDetail = taskGuideDetailRepository.findById(id)
                .orElseThrow(() -> new TaskGuideHandler(ErrorStatus.TaskGuide_DETAIL_NOT_FOUND));

        taskGuideDetailRepository.delete(taskGuideDetail);
    }
}
