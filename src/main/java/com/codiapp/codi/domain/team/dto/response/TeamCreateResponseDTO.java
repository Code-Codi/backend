package com.codiapp.codi.domain.team.dto.response;

import lombok.Builder;

@Builder
public record TeamCreateResponseDTO (
	Long id,
	String name
) {}
