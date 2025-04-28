package com.example.codi.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDAO projectDAO;

    @Override
    public List<Project> getAllProjects() {
        return projectDAO.findAllProjects();
    }

    @Override
    public Project getProjectById(String projectId) {
        return projectDAO.findProjectById(projectId);
    }

    @Override
    public void createProject(Project project) {
        projectDAO.insertProject(project);
    }

    @Override
    public void updateProject(Project project) {
        projectDAO.updateProject(project);
    }

    @Override
    public void deleteProject(String projectId) {
        projectDAO.deleteProject(projectId);
    }
}
