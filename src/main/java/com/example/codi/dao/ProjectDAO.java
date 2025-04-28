package com.example.codi.dao;

import java.util.List;

public interface ProjectDAO {
	// 프로젝트 추가
	void insertProject(Project project);

	// 모든 프로젝트 조회
	List<Project> findAllProjects();

	// 특정 프로젝트 조회
	Project findProjectById(String projectId);

	// 프로젝트 수정
	void updateProject(Project project);

	// 프로젝트 삭제
	void deleteProject(String projectId);
}
