package com.codiapp.codi.domain.team.service;

import java.util.List;

import com.codiapp.codi.domain.course.entity.Course;
import com.codiapp.codi.domain.course.repository.CourseRepository;
import com.codiapp.codi.global.apiPayload.code.status.ErrorStatus;
import com.codiapp.codi.global.apiPayload.exception.handler.CourseHandler;
import com.codiapp.codi.global.apiPayload.exception.handler.TeamHandler;
import com.codiapp.codi.global.apiPayload.exception.handler.UserHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codiapp.codi.domain.user.entity.User;
import com.codiapp.codi.domain.user.repository.UserRepository;
import com.codiapp.codi.domain.team.converter.TeamConverter;
import com.codiapp.codi.domain.team.dto.request.TeamRequestDTO;
import com.codiapp.codi.domain.team.dto.response.TeamCreateResponseDTO;
import com.codiapp.codi.domain.team.entity.Team;
import com.codiapp.codi.domain.team.entity.UserTeam;
import com.codiapp.codi.domain.team.repository.TeamRepository;
import com.codiapp.codi.domain.team.repository.UserTeamRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeamCommandServiceImpl implements TeamCommandService {
    private final TeamRepository teamRepository;
    private final UserRepository userRepository;
    private final UserTeamRepository userTeamRepository;
    private final CourseRepository courseRepository;

    @Override
    @Transactional
    public TeamCreateResponseDTO createTeam(TeamRequestDTO requestDTO) {
        Course course = courseRepository.findById(requestDTO.courseId())
                .orElseThrow(() -> new CourseHandler(ErrorStatus.COURSE_NOT_FOUND));

        // 팀 멤버가 이미 해당 수업의 팀에 속했는지 검사
        List<User> teamMembers = requestDTO.memberEmails().stream()
                .map(email -> {
                    User user = userRepository.findByEmail(email)
                            .orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));
                    if (userTeamRepository.existsByUserAndTeam_Course(user, course)) {
                        throw new TeamHandler(ErrorStatus.USER_ALREADY_IN_COURSE);
                    }
                    return user;
                }).toList();

        Team team = TeamConverter.toTeam(requestDTO, course);
        teamRepository.save(team);

       List<UserTeam> userTeams = teamMembers.stream()
            .map(teamMember -> TeamConverter.toUserTeam(teamMember, team)).toList();

        userTeamRepository.saveAll(userTeams);
        return TeamConverter.toCreateResponseDTO(team);
    }

    @Override
    @Transactional
    public void updateTeam(Long teamId, TeamRequestDTO requestDTO) {
        Team team = teamRepository.findById(teamId)
            .orElseThrow(() -> new TeamHandler(ErrorStatus.TEAM_NOT_FOUND));

        if (requestDTO.name() != null && !requestDTO.name().isBlank()) {
            team.updateName(requestDTO.name());
        }

        Course course = courseRepository.findById(requestDTO.courseId())
                .orElseThrow(() -> new CourseHandler(ErrorStatus.COURSE_NOT_FOUND));

        team.updateCourse(course);

        if (requestDTO.memberEmails() != null && !requestDTO.memberEmails().isEmpty()) {
        	List<UserTeam> existing = userTeamRepository.findByTeamId(teamId);
            userTeamRepository.deleteAll(existing);
            userTeamRepository.flush();
            
            List<UserTeam> newUserTeams = requestDTO.memberEmails().stream()
            	    .map(email -> {
            	        User user = userRepository.findByEmail(email)
            	            .orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));

            	        return TeamConverter.toUserTeam(user, team);
            	    }).toList();

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
}
