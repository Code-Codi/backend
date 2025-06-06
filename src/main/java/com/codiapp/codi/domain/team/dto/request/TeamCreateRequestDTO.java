package com.codiapp.codi.domain.team.dto.request;

import java.util.List;

public record TeamCreateRequestDTO (
	String name,
	List<String> memberEmails 
) {}
