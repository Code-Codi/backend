package com.codiapp.codi.domain.team.service;

import java.util.List;

import com.codiapp.codi.domain.team.dto.request.TeamCreateRequestDTO;
import com.codiapp.codi.domain.team.dto.request.TeamUpdateRequestDTO;
import com.codiapp.codi.domain.team.dto.response.TeamCreateResponseDTO;
import com.codiapp.codi.domain.team.dto.response.UserNameResponseDTO;
import com.codiapp.codi.domain.team.entity.Team;

public interface TeamService {

	List<Team> getAllTeamLists();
	
	//void createTeam(Team team);

	TeamCreateResponseDTO createTeam(TeamCreateRequestDTO requestDTO);

	List<Team> getTeamsByUserId(Long userId);
	
	List<String> getUserNamesByTeamId(Long teamId);
	
	void updateTeam(Long teamId, TeamUpdateRequestDTO dto);
	
	void leaveTeam(Long teamId, Long userId);

	List<UserNameResponseDTO> getUserInfosByTeamId(Long teamId);


}
