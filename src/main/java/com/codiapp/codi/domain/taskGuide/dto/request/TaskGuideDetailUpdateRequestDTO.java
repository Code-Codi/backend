package com.codiapp.codi.domain.taskGuide.dto.request;

import java.util.Optional;

public record TaskGuideDetailUpdateRequestDTO(
        Optional<String> title,
        Optional<String> description
) {}
