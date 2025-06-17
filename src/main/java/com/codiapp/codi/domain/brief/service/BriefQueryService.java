package com.codiapp.codi.domain.brief.service;

import com.codiapp.codi.domain.brief.dto.response.BriefResponseDTO;

public interface BriefQueryService {
    BriefResponseDTO getBrief(Long briefId);
}
