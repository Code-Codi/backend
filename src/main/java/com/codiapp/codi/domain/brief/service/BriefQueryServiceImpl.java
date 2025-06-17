package com.codiapp.codi.domain.brief.service;

import com.codiapp.codi.domain.brief.converter.BriefConverter;
import com.codiapp.codi.domain.brief.dto.response.BriefResponseDTO;
import com.codiapp.codi.domain.brief.entity.Brief;
import com.codiapp.codi.domain.brief.repository.BriefRepository;
import com.codiapp.codi.global.apiPayload.exception.handler.TaskGuideHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.codiapp.codi.global.apiPayload.code.status.ErrorStatus.TASK_GUIDE_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class BriefQueryServiceImpl implements BriefQueryService {
    private final BriefRepository briefRepository;

    @Override
    public BriefResponseDTO getBrief(Long briefId){
        Brief brief = briefRepository.findById(briefId)
                .orElseThrow(() -> new TaskGuideHandler(TASK_GUIDE_NOT_FOUND));
        return BriefConverter.toTaskGuideResponeDTO(brief);
    }
}
