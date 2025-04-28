package com.example.codi.service;

import java.util.List;

public interface ProjectService {
    List<Project> getAllProjects();
    Project getProjectById(String projectId);
    void createProject(Project project);
    void updateProject(Project project);
    void deleteProject(String projectId);
}