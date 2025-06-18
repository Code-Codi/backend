package com.codiapp.codi.domain.brief.service;

import com.codiapp.codi.domain.brief.dto.request.BriefCreateRequestDTO;
import com.codiapp.codi.domain.brief.dto.request.BriefUpdateRequestDTO;

public interface BriefCommandService {
    Long createBrief(BriefCreateRequestDTO request);
    void updateBrief(Long briefId,BriefUpdateRequestDTO request);
}
