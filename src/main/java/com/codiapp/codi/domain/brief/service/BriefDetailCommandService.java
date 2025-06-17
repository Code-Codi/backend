package com.codiapp.codi.domain.brief.service;

import com.codiapp.codi.domain.brief.dto.request.BriefDetailCreateRequestDTO;

public interface BriefDetailCommandService {
    Long createBriefDetail(BriefDetailCreateRequestDTO request);
}
