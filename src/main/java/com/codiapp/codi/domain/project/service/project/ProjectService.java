package com.codiapp.codi.domain.project.service.project;

import java.util.List;

import com.codiapp.codi.domain.project.entity.project.Project;

public interface ProjectService {
	
	  List<Project> getAllProjects();
	
	  void createProject(Project project);

	  void updateProject(Project project);
	  
	  void deleteProject(Long id);

}
