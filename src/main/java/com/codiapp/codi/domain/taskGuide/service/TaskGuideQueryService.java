package com.codiapp.codi.domain.taskGuide.service;

import com.codiapp.codi.domain.taskGuide.dto.response.TaskGuideResponseDTO;

public interface TaskGuideQueryService {
    TaskGuideResponseDTO getTaskGuide(Long id);
}
