package com.codiapp.codi.domain.team.service;

import com.codiapp.codi.domain.team.converter.TeamConverter;
import com.codiapp.codi.domain.team.dto.response.TeamInfoResponseDTO;
import com.codiapp.codi.domain.team.dto.response.TeamReadResponseDTO;
import com.codiapp.codi.domain.team.dto.response.UserNameResponseDTO;
import com.codiapp.codi.domain.team.dto.response.UserTeamMemberResponseDTO;
import com.codiapp.codi.domain.team.entity.Team;
import com.codiapp.codi.domain.team.entity.UserTeam;
import com.codiapp.codi.domain.team.repository.TeamRepository;
import com.codiapp.codi.domain.team.repository.UserTeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamQueryServiceImpl implements TeamQueryService {
    private final TeamRepository teamRepository;
    private final UserTeamRepository userTeamRepository;

    @Override
    @Transactional(readOnly = true)
    public List<TeamReadResponseDTO> getTeamsByUserId(Long userId) {
        return userTeamRepository.findTeamsByUserId(userId).stream()
                .map(TeamConverter::toReadResponseDTO).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserNameResponseDTO> getUserInfosByTeamId(Long teamId) {
        List<UserTeam> userTeams = userTeamRepository.findByTeamId(teamId);
        return userTeams.stream()
                .map(ut -> UserNameResponseDTO.builder()
                        .email(ut.getUser().getEmail())
                        .userName(ut.getUser().getUsername())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<TeamInfoResponseDTO> getTeamsByCourse(Long courseId) {
        List<Team> teams = teamRepository.findByCourseId(courseId);
        return teams.stream()
                .map(TeamConverter::toTeamInfoResponseDTO)
                .toList();
    }

    public List<UserTeamMemberResponseDTO> getUserTeamMembers(Long teamId) {
        List<UserTeam> userTeams = userTeamRepository.findAllByTeamId(teamId);
        return userTeams.stream()
                .map(TeamConverter::toUserTeamMemberDTO)
                .toList();
    }
}
