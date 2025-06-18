package com.codiapp.codi.domain.task.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record FinalTaskResponseDTO(
   Long taskId,
   String teamName,
   LocalDate taskDate,

   Long taskGuideId,
   String title,
   LocalDateTime dueDate,
   LocalDateTime createAt,
   List<FinalDetailResponseDTO> details
) {}
