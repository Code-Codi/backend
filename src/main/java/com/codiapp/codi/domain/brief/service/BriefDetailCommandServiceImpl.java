package com.codiapp.codi.domain.brief.service;

import com.codiapp.codi.domain.brief.converter.BriefConverter;
import com.codiapp.codi.domain.brief.dto.request.BriefDetailCreateRequestDTO;
import com.codiapp.codi.domain.brief.entity.Brief;
import com.codiapp.codi.domain.brief.entity.BriefDetail;
import com.codiapp.codi.domain.brief.repository.BriefDetailRepository;
import com.codiapp.codi.domain.brief.repository.BriefRepository;
import com.codiapp.codi.global.apiPayload.code.status.ErrorStatus;
import com.codiapp.codi.global.apiPayload.exception.handler.BriefHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BriefDetailCommandServiceImpl implements BriefDetailCommandService {
    private final BriefDetailRepository briefDetailRepository;
    private final BriefRepository briefRepository;

    public @Override Long createBriefDetail(BriefDetailCreateRequestDTO request) {
        Brief brief = briefRepository.findById(request.briefId())
                .orElseThrow(() -> new BriefHandler(ErrorStatus.BRIEF_NOT_FOUND));

        BriefDetail detail = BriefConverter.toTaskGuideDetail(request, brief);
        return briefDetailRepository.save(detail).getId();
    }
}
