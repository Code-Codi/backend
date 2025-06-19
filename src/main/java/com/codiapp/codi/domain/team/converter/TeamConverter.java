package com.codiapp.codi.domain.team.converter;

import com.codiapp.codi.domain.course.entity.Course;
import com.codiapp.codi.domain.team.dto.request.TeamRequestDTO;
import com.codiapp.codi.domain.team.dto.response.TeamCreateResponseDTO;
import com.codiapp.codi.domain.team.dto.response.TeamInfoResponseDTO;
import com.codiapp.codi.domain.team.dto.response.TeamReadResponseDTO;
import com.codiapp.codi.domain.team.entity.Team;
import com.codiapp.codi.domain.team.entity.UserTeam;
import com.codiapp.codi.domain.user.entity.User;

public class TeamConverter {
	public static TeamReadResponseDTO toReadResponseDTO(Team team) {
        return TeamReadResponseDTO.builder()
                .id(team.getId())
                .name(team.getName())
                .courseId(team.getCourse().getId())
                .build();
    }

    public static Team toTeam(TeamRequestDTO request, Course course) {
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
