package com.codiapp.codi.domain.project.controller.project;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codiapp.codi.domain.project.converter.ProjectConverter;
import com.codiapp.codi.domain.project.dto.request.ProjectCreateRequestDTO;
import com.codiapp.codi.domain.project.dto.request.ProjectUpdateRequestDTO;
import com.codiapp.codi.domain.project.dto.response.ProjectCreateResponseDTO;
import com.codiapp.codi.domain.project.dto.response.ProjectReadResponseDTO;
import com.codiapp.codi.domain.project.dto.response.ProjectUpdateResponseDTO;
import com.codiapp.codi.domain.project.entity.project.Project;
import com.codiapp.codi.domain.project.service.project.ProjectService;
import com.codiapp.codi.global.apiPayload.ApiResponse;
import com.codiapp.codi.global.apiPayload.code.status.SuccessStatus;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project")
public class ProjectController {
	
    private final ProjectService projectService;
    
    
    //프로젝트 전체 조회 
    @GetMapping
    public ApiResponse<List<ProjectReadResponseDTO>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        List<ProjectReadResponseDTO> response = ProjectConverter.toReadResponseDTO(projects);
        return ApiResponse.of(SuccessStatus._OK, response);
    }
    
   //create
    @PostMapping
    public ApiResponse<ProjectCreateResponseDTO> createProject(@RequestBody ProjectCreateRequestDTO requestDTO) {

        Project project = ProjectConverter.toEntityForCreate(requestDTO);  
        project.setTeamId(1L); //팀 id 하드코딩
        projectService.createProject(project); 

        ProjectCreateResponseDTO responseDTO = ProjectConverter.toCreateResponseDTO(project);
        return ApiResponse.of(SuccessStatus._OK, responseDTO); 
    }

    
    @PatchMapping("/{id}")
    public ApiResponse<ProjectUpdateResponseDTO> updateProject(
        @PathVariable("id") Long id,
        @RequestBody ProjectUpdateRequestDTO requestDTO) {

        Project project = ProjectConverter.toEntityForUpdate(id, requestDTO);
        project.setTeamId(1L); //팀 id 하드코딩
        projectService.updateProject(project);
        ProjectUpdateResponseDTO responseDTO = ProjectConverter.toUpdateResponseDTO(project);
        return ApiResponse.of(SuccessStatus._OK, responseDTO);
    }

    //delete
    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteProject(@PathVariable("id") Long id) {
        projectService.deleteProject(id);
        return ApiResponse.of(SuccessStatus._OK, "프로젝트가 성공적으로 삭제되었습니다.");
    }


}
