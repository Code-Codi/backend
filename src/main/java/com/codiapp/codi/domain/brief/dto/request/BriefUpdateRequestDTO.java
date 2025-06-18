package com.codiapp.codi.domain.brief.dto.request;

import java.time.LocalDateTime;
import java.util.Optional;

public record BriefUpdateRequestDTO(
        Optional<String> title,
        Optional<LocalDateTime> dueDate
) {}
