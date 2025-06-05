package com.codiapp.codi.domain.team.dto.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamUpdateRequestDTO {
	private String name;
	private List<String> memberEmails;
}
