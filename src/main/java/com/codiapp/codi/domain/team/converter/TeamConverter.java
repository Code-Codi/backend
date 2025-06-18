package com.codiapp.codi.domain.team.converter;

import com.codiapp.codi.domain.course.entity.Course;
import com.codiapp.codi.domain.team.dto.request.TeamCreateRequestDTO;
import com.codiapp.codi.domain.team.dto.response.TeamCreateResponseDTO;
import com.codiapp.codi.domain.team.dto.response.TeamInfoResponseDTO;
import com.codiapp.codi.domain.team.dto.response.TeamReadResponseDTO;
import com.codiapp.codi.domain.team.entity.Team;
import com.codiapp.codi.domain.team.entity.UserTeam;
import com.codiapp.codi.domain.user.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class TeamConverter {

	public static TeamReadResponseDTO toReadResponseDTO(Team team) {
        return TeamReadResponseDTO.builder()
                .id(team.getId())
                .name(team.getName())
                .build();
    }

    public static List<TeamReadResponseDTO> toReadResponseDTO(List<Team> teams) {
        return teams.stream()
                .map(TeamConverter::toReadResponseDTO)
                .collect(Collectors.toList());
    }
	    
    public static Team toTeam(TeamCreateRequestDTO request, Course course) {
        return Team.builder()
                .course(course)
                .name(request.name())
                .build();
    }
    public static UserTeam toUserTeam(User user, Team team) {
        return UserTeam.builder()
                .user(user)
                .team(team)
                .build();
    }

    public static TeamCreateResponseDTO toCreateResponseDTO(Team team) {
        return TeamCreateResponseDTO.builder()
                .id(team.getId())
                .name(team.getName())
                .build();
    }

    public static TeamInfoResponseDTO toTeamInfoResponseDTO(Team team) {
        return new TeamInfoResponseDTO(team.getId(), team.getName());
    }
}
