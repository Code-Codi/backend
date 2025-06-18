package com.codiapp.codi.domain.taskGuide.dto.request;

import java.time.LocalDateTime;
import java.util.Optional;

public record TaskGuideUpdateRequestDTO(
        Optional<String> title,
        Optional<LocalDateTime> dueDate
) {}
