package com.codiapp.codi.domain.team.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codiapp.codi.domain.team.entity.User;
import com.codiapp.codi.domain.team.repository.UserRepository;
import com.codiapp.codi.domain.team.converter.TeamConverter;
import com.codiapp.codi.domain.team.dto.request.TeamCreateRequestDTO;
import com.codiapp.codi.domain.team.dto.request.TeamUpdateRequestDTO;
import com.codiapp.codi.domain.team.dto.response.TeamCreateResponseDTO;
import com.codiapp.codi.domain.team.dto.response.UserNameResponseDTO;
import com.codiapp.codi.domain.team.entity.Team;
import com.codiapp.codi.domain.team.entity.UserTeam;
import com.codiapp.codi.domain.team.repository.TeamRepository;
import com.codiapp.codi.domain.team.repository.UserTeamRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final UserRepository userRepository;
    private final UserTeamRepository userTeamRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Team> getAllTeamLists() {
        return teamRepository.findAll();
    }

    @Override
    @Transactional
    public TeamCreateResponseDTO createTeam(TeamCreateRequestDTO requestDTO) {
        Team team = Team.builder()
                .name(requestDTO.name())
                .build();
        teamRepository.save(team);

        Team savedTeam = teamRepository.save(team);
       List<UserTeam> userTeams = requestDTO.memberEmails().stream()
            .map(email -> {
                User user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다: " + email));
                  return UserTeam.builder()
                    .team(savedTeam)
                    .user(user)
                    .build();
            })
            .collect(Collectors.toList());

        userTeamRepository.saveAll(userTeams);


        return TeamConverter.toCreateResponseDTO(team);
    }
  
    @Override
    @Transactional(readOnly = true)
    public List<Team> getTeamsByUserId(Long userId) {
        return userTeamRepository.findTeamsByUserId(userId); // 바로 Team 목록 반환
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getUserNamesByTeamId(Long teamId) {
        List<UserTeam> userTeams = userTeamRepository.findByTeamId(teamId);
        return userTeams.stream()
            .map(userTeam -> userTeam.getUser().getUserName())
            .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void updateTeam(Long teamId, TeamUpdateRequestDTO dto) {
        Team team = teamRepository.findById(teamId)
            .orElseThrow(() -> new IllegalArgumentException("팀이 존재하지 않습니다."));

        if (dto.name() != null && !dto.name().isBlank()) {
            team.updateName(dto.name());
        }
        if (dto.memberEmails() != null && !dto.memberEmails().isEmpty()) {
        	List<UserTeam> existing = userTeamRepository.findByTeamId(teamId);
            userTeamRepository.deleteAll(existing);
            userTeamRepository.flush();
            
            List<UserTeam> newUserTeams = dto.memberEmails().stream()
            	    .map(email -> {
            	        User user = userRepository.findByEmail(email)
            	            .orElseThrow(() -> {
            	                return new IllegalArgumentException("해당 유저 없음: " + email);
            	            });

            	        return UserTeam.builder()
            	            .team(team)
            	            .user(user)
            	            .build();
            	    })
            	    .collect(Collectors.toList());

            	userTeamRepository.saveAll(newUserTeams);

        }
    }

    @Override
    @Transactional
    public void leaveTeam(Long teamId, Long userId) {
        List<UserTeam> userTeams = userTeamRepository.findByTeamId(teamId);
        UserTeam toRemove = userTeams.stream()
            .filter(ut -> ut.getUser().getId().equals(userId))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("해당 팀에 속한 유저가 아님"));

        userTeamRepository.delete(toRemove);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserNameResponseDTO> getUserInfosByTeamId(Long teamId) {
        List<UserTeam> userTeams = userTeamRepository.findByTeamId(teamId);
        return userTeams.stream()
            .map(ut -> UserNameResponseDTO.builder()
                .email(ut.getUser().getEmail())
                .userName(ut.getUser().getUserName())
                .build())
            .collect(Collectors.toList());
    }

}
