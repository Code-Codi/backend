package com.example.codi.service;

import java.util.List;

public interface SubProjectService {
    List<SubProject> getSubProjectsByProjectId(String projectId);
    List<SubProject> getSubProjectsByStatus(String projectId, String status);
    void createSubProject(SubProject subProject);
    void updateSubProject(SubProject subProject);
    void deleteSubProject(String subProjectId);
}
