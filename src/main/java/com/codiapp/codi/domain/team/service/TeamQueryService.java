package com.codiapp.codi.domain.team.service;

import com.codiapp.codi.domain.team.dto.response.TeamInfoResponseDTO;
import com.codiapp.codi.domain.team.dto.response.UserNameResponseDTO;
import com.codiapp.codi.domain.team.entity.Team;

import java.util.List;

public interface TeamQueryService {
    List<Team> getAllTeamLists();
    List<Team> getTeamsByUserId(Long userId);
    List<String> getUserNamesByTeamId(Long teamId);
    List<UserNameResponseDTO> getUserInfosByTeamId(Long teamId);
    List<TeamInfoResponseDTO> getTeamsByCourse(Long courseId);
}
