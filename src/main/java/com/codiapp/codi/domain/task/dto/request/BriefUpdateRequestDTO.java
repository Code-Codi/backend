package com.codiapp.codi.domain.task.dto.request;

import java.util.Optional;

public record BriefUpdateRequestDTO(
        Optional<String> title,
        Optional<String> content
) {}
