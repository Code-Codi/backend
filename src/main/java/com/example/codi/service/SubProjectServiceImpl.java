package com.example.codi.service;

import org.springframework.stereotype.Service;

@Service
public class SubProjectServiceImpl implements SubProjectService {

    @Autowired
    private SubProjectDAO subProjectDAO;

    @Override
    public List<SubProject> getSubProjectsByProjectId(String projectId) {
        return subProjectDAO.findSubProjectsByProjectId(projectId);
    }

    @Override
    public List<SubProject> getSubProjectsByStatus(String projectId, String status) {
        return subProjectDAO.findSubProjectsByStatus(projectId, status);
    }

    @Override
    public void createSubProject(SubProject subProject) {
        subProjectDAO.insertSubProject(subProject);
    }

    @Override
    public void updateSubProject(SubProject subProject) {
        subProjectDAO.updateSubProject(subProject);
    }

    @Override
    public void deleteSubProject(String subProjectId) {
        subProjectDAO.deleteSubProject(subProjectId);
    }
}
