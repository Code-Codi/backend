package com.codiapp.codi.domain.team.service;

import com.codiapp.codi.domain.team.dto.response.TeamInfoResponseDTO;
import com.codiapp.codi.domain.team.dto.response.TeamReadResponseDTO;
import com.codiapp.codi.domain.team.dto.response.UserNameResponseDTO;

import java.util.List;

public interface TeamQueryService {
    List<TeamReadResponseDTO> getTeamsByUserId(Long userId);
    List<UserNameResponseDTO> getUserInfosByTeamId(Long teamId);
    List<TeamInfoResponseDTO> getTeamsByCourse(Long courseId);
}
