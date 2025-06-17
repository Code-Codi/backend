package com.codiapp.codi.domain.brief.service;

import com.codiapp.codi.domain.brief.dto.request.BriefCreateRequestDTO;

public interface BriefCommandService {
    Long createBrief(BriefCreateRequestDTO request);
}
