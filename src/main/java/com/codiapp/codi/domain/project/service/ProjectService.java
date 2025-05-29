package com.codiapp.codi.domain.project.service;

import java.util.List;

import com.codiapp.codi.domain.project.entity.Project;

public interface ProjectService {
	
	  List<Project> getProjectsByTeamId(Long teamId);
	
	  void createProject(Project project);

	  void updateProject(Project project);
	  
	  void deleteProject(Long id);

}
