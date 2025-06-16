package com.codiapp.codi.domain.team.service;

import java.util.List;

import com.codiapp.codi.domain.team.dto.request.TeamCreateRequestDTO;
import com.codiapp.codi.domain.team.dto.request.TeamUpdateRequestDTO;
import com.codiapp.codi.domain.team.dto.response.TeamCreateResponseDTO;

public interface TeamCommandService {
	TeamCreateResponseDTO createTeam(TeamCreateRequestDTO requestDTO);
	void updateTeam(Long teamId, TeamUpdateRequestDTO dto);
	void leaveTeam(Long teamId, Long userId);
}
