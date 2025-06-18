package com.codiapp.codi.domain.task.dto.request;

import java.util.List;

public record FinalTaskUpdateRequestDTO(
        List<FinalDetailUpdateRequestDTO> details
) {}
