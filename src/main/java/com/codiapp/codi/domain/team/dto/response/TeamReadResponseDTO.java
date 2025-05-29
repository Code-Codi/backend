package com.codiapp.codi.domain.team.dto.response;

import lombok.Builder;

@Builder
public record TeamReadResponseDTO(
	Long id,
	String name
) {
}
