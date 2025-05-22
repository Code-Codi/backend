package com.codiapp.codi.domain.project.dto.response;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectUpdateResponseDTO {
	 private Long id;
	 private String message;
	 private LocalDateTime updatedAt;
}
