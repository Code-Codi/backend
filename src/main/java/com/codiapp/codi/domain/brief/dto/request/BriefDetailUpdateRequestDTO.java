package com.codiapp.codi.domain.brief.dto.request;

import java.util.Optional;

public record BriefDetailUpdateRequestDTO(
        Optional<String> title,
        Optional<String> description
) {}
