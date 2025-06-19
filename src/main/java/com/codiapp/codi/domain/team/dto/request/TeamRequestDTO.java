package com.codiapp.codi.domain.team.dto.request;

import java.util.List;

public record TeamRequestDTO(
		Long userId,
		Long courseId,
		String name,
		List<String> memberEmails
) {}
