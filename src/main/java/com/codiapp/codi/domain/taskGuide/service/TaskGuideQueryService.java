package com.codiapp.codi.domain.taskGuide.service;

import com.codiapp.codi.domain.taskGuide.dto.response.TaskGuideListResponseDTO;
import com.codiapp.codi.domain.taskGuide.dto.response.TaskGuideResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskGuideQueryService {
    TaskGuideResponseDTO getTaskGuide(Long id);
    Page<TaskGuideListResponseDTO> getAllTaskGuides(Long courseId, Pageable pageable);
}
