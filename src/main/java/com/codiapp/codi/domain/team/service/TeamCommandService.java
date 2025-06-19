package com.codiapp.codi.domain.team.service;

import com.codiapp.codi.domain.team.dto.request.TeamRequestDTO;
import com.codiapp.codi.domain.team.dto.response.TeamCreateResponseDTO;

public interface TeamCommandService {
	TeamCreateResponseDTO createTeam(TeamRequestDTO requestDTO);
	void updateTeam(Long teamId, TeamRequestDTO dto);
	void leaveTeam(Long teamId, Long userId);
}
