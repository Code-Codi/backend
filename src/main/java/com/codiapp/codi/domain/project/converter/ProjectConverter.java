package com.codiapp.codi.domain.project.converter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.codiapp.codi.domain.project.dto.request.ProjectCreateRequestDTO;
import com.codiapp.codi.domain.project.dto.request.ProjectUpdateRequestDTO;
import com.codiapp.codi.domain.project.dto.response.ProjectCreateResponseDTO;
import com.codiapp.codi.domain.project.dto.response.ProjectReadResponseDTO;
import com.codiapp.codi.domain.project.dto.response.ProjectUpdateResponseDTO;
import com.codiapp.codi.domain.project.entity.project.Project;

public class ProjectConverter {

	public static Project toEntityForCreate(ProjectCreateRequestDTO dto) {
		Project project = new Project();
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setStartDate(dto.getStartDate());
        project.setEndDate(dto.getEndDate());
        project.setDeadline(dto.getDeadline());
        project.setTargetDeadline(dto.getTargetDeadline());
        project.setPriority(dto.getPriority());
        project.setProgressPercent(dto.getProgressPercent());
        project.setStatus(dto.getStatus());
        project.setTeamId(dto.getTeamId());
        project.setManager(dto.getManager());
        return project;
	}
	
	public static ProjectCreateResponseDTO toCreateResponseDTO(Project project) {
		return ProjectCreateResponseDTO.builder()
				.id(project.getId())
				.name(project.getName())
				.status(project.getStatus())
				.createdAt(LocalDateTime.now())
				.build();
	}
	
	 public static ProjectReadResponseDTO toReadResponseDTO(Project project) {
	        return ProjectReadResponseDTO.builder()
	                .id(project.getId())
	                .name(project.getName())
	                .description(project.getDescription())
	                .startDate(project.getStartDate())
	                .endDate(project.getEndDate())
	                .targetDeadline(project.getTargetDeadline())
	                .deadline(project.getDeadline())
	                .priority(project.getPriority())
	                .manager(project.getManager())
	                .progressPercent(project.getProgressPercent())
	                .status(project.getStatus())
	                .teamId(project.getTeamId())
	                .build();
	    }

	    //리스트 전체 변환
	    public static List<ProjectReadResponseDTO> toReadResponseDTO(List<Project> projects) {
	        return projects.stream()
	                .map(ProjectConverter::toReadResponseDTO)
	                .collect(Collectors.toList());
	    }
	    
	    public static Project toEntityForUpdate(Long id, ProjectUpdateRequestDTO dto) {
	        Project project = new Project();
	        project.setId(id);
	        project.setName(dto.getName());
	        project.setDescription(dto.getDescription());
	        project.setStartDate(dto.getStartDate());
	        project.setEndDate(dto.getEndDate());
	        project.setDeadline(dto.getDeadline());
	        project.setTargetDeadline(dto.getTargetDeadline());
	        project.setPriority(dto.getPriority());
	        project.setProgressPercent(dto.getProgressPercent());
	        project.setStatus(dto.getStatus());
	        project.setManager(dto.getManager());
	        return project;
	    }

	    public static ProjectUpdateResponseDTO toUpdateResponseDTO(Project project) {
	        return ProjectUpdateResponseDTO.builder()
	                .id(project.getId())
	                .message("프로젝트가 성공적으로 수정되었습니다.")
	                .updatedAt(LocalDateTime.now())
	                .build();
	    }

}
