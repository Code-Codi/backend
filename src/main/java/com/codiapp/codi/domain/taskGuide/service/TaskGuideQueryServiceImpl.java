package com.codiapp.codi.domain.taskGuide.service;

import com.codiapp.codi.domain.taskGuide.converter.TaskGuideConverter;
import com.codiapp.codi.domain.taskGuide.dto.response.TaskGuideListResponseDTO;
import com.codiapp.codi.domain.taskGuide.dto.response.TaskGuideResponseDTO;
import com.codiapp.codi.domain.taskGuide.entity.TaskGuide;
import com.codiapp.codi.domain.taskGuide.repository.TaskGuideRepository;
import com.codiapp.codi.global.apiPayload.exception.handler.TaskGuideHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.codiapp.codi.global.apiPayload.code.status.ErrorStatus.TASKGUIDE_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class TaskGuideQueryServiceImpl implements TaskGuideQueryService {
    private final TaskGuideRepository taskGuideRepository;

    @Override
    public TaskGuideResponseDTO getTaskGuide(Long id){
        TaskGuide taskGuide = taskGuideRepository.findById(id)
                .orElseThrow(() -> new TaskGuideHandler(TASKGUIDE_NOT_FOUND));
        return TaskGuideConverter.toTaskGuideResponeDTO(taskGuide);
    }

    @Override
    public Page<TaskGuideListResponseDTO> getAllTaskGuides(Long courseId, Pageable pageable) {
        return taskGuideRepository.findAllByCourseId(courseId, pageable)
                .map(TaskGuideConverter::taskGuideListResponseDTO);
    }

}
