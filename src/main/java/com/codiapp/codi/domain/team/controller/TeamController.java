package com.codiapp.codi.domain.team.controller;

import java.util.List;

import com.codiapp.codi.domain.team.dto.response.TeamInfoResponseDTO;
import com.codiapp.codi.domain.team.dto.response.TeamReadResponseDTO;
import com.codiapp.codi.domain.team.service.TeamCommandService;
import com.codiapp.codi.domain.team.service.TeamQueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codiapp.codi.domain.team.converter.TeamConverter;
import com.codiapp.codi.domain.team.dto.request.TeamRequestDTO;
import com.codiapp.codi.domain.team.dto.response.TeamCreateResponseDTO;
import com.codiapp.codi.domain.team.dto.response.UserNameResponseDTO;
import com.codiapp.codi.domain.team.entity.Team;
import com.codiapp.codi.global.apiPayload.ApiResponse;
import com.codiapp.codi.global.apiPayload.code.status.SuccessStatus;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teamProject")
public class TeamController {
    private final TeamCommandService teamCommandService;
    private final TeamQueryService teamQueryService;

    // 팀 전체 조회
//    @GetMapping
//    public ApiResponse<List<TeamReadResponseDTO>> getAllTeamLists() {
//        List<Team> teamList = teamService.getAllTeamLists();
//        List<TeamReadResponseDTO> response = TeamConverter.toReadResponseDTO(teamList);
//        return ApiResponse.of(SuccessStatus._OK, response);
//    }

    // 팀 생성 (이름 + 팀원 이메일 리스트)
    @PostMapping
    public ApiResponse<TeamCreateResponseDTO> createTeam(@RequestBody TeamRequestDTO requestDTO) {
        TeamCreateResponseDTO responseDTO = teamCommandService.createTeam(requestDTO);
        return ApiResponse.of(SuccessStatus._OK, responseDTO);
    }
    
    @GetMapping("/my/{id}")
    public ApiResponse<List<TeamReadResponseDTO>> getMyTeams(@PathVariable("id") Long userId) {
        return ApiResponse.of(SuccessStatus._OK, teamQueryService.getTeamsByUserId(userId));
    }

    @GetMapping("/{teamId}/members")
    public ApiResponse<List<UserNameResponseDTO>> getTeamMembers(@PathVariable("teamId") Long teamId) {
        List<UserNameResponseDTO> userInfos = teamQueryService.getUserInfosByTeamId(teamId);
        return ApiResponse.of(SuccessStatus._OK, userInfos);
    }

    
    @PatchMapping("/{teamId}")
    public ApiResponse<?> updateTeam(@PathVariable("teamId") Long teamId, @RequestBody TeamRequestDTO dto) {
        teamCommandService.updateTeam(teamId, dto);
        return ApiResponse.of(SuccessStatus._OK, null);
    }

    @DeleteMapping("/{teamId}/member/{userId}")
    public ApiResponse<?> leaveTeam(@PathVariable("teamId") Long teamId, @PathVariable("userId") Long userId) {
        teamCommandService.leaveTeam(teamId, userId);
        return ApiResponse.of(SuccessStatus._OK, null);
    }

    @GetMapping("/teams/course")
    public ResponseEntity<ApiResponse<List<TeamInfoResponseDTO>>> getTeamsByCourse(
            @RequestParam Long courseId
    ) {
        List<TeamInfoResponseDTO> response = teamQueryService.getTeamsByCourse(courseId);
        return ResponseEntity.ok(ApiResponse.onSuccess(response));
    }

}
