package com.codiapp.codi.domain.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codiapp.codi.global.apiPayload.exception.handler.ProjectHandler;
import com.codiapp.codi.domain.project.entity.Project;
import com.codiapp.codi.domain.project.repository.ProjectRepository;
import com.codiapp.codi.global.apiPayload.code.status.ErrorStatus;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Project> getProjectsByTeamId(Long teamId) {
        return projectRepository.findByTeamId(teamId);
    }


    @Override
    public void createProject(Project project) {
        if (project.getName() == null || project.getName().trim().isEmpty()) {
            throw new ProjectHandler(ErrorStatus._BAD_REQUEST); 
        }
        if (project.getTeamId() == null) {
            throw new ProjectHandler(ErrorStatus._BAD_REQUEST);
        }
        projectRepository.save(project);
    }

    @Override
    public void updateProject(Project project) {
        projectRepository.findById(project.getId())
                .orElseThrow(() -> new ProjectHandler(ErrorStatus.PROJECT_NOT_FOUND));
        projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectHandler(ErrorStatus.PROJECT_NOT_FOUND));
        projectRepository.delete(project);
    }
}
