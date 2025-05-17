package com.codiapp.codi.domain.project.service.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codiapp.codi.domain.project.entity.project.Project;
import com.codiapp.codi.domain.project.repository.project.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	 @Autowired
	    private ProjectRepository projectRepository;

	    @Override
	    public List<Project> getAllProjects() {
	        return projectRepository.findAll();
	    }

	    @Override
	    public void createProject(Project project) {
	    	projectRepository.save(project);
	    }
	    
	    @Override
	    public void updateProject(Project project) {
	    	projectRepository.save(project);
	    }
	    
	    @Override
	    public void deleteProject(int id) {
	    	projectRepository.deleteById(id);
	    }

}
