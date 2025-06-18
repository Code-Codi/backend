package com.codiapp.codi.domain.brief.service;

import com.codiapp.codi.domain.brief.dto.request.BriefDetailCreateRequestDTO;
import com.codiapp.codi.domain.brief.dto.request.BriefDetailUpdateRequestDTO;

public interface BriefDetailCommandService {
    Long createBriefDetail(BriefDetailCreateRequestDTO request);

    void updateBriefDetail(Long briefDetailId, BriefDetailUpdateRequestDTO request);
}
