package com.example.codi.dao;

import java.util.List;

public interface SubProjectDAO {
	  // 서브프로젝트 추가
  void insertSubProject(SubProject subProject);

  // 특정 프로젝트에 속한 모든 서브프로젝트 조회
  List<SubProject> findSubProjectsByProjectId(String projectId);

  // 특정 서브프로젝트 조회
  SubProject findSubProjectById(String subProjectId);

  // 서브프로젝트 수정
  void updateSubProject(SubProject subProject);

  // 서브프로젝트 삭제
  void deleteSubProject(String subProjectId);

  // 특정 상태(할 일/진행중/완료)에 따라 서브프로젝트 조회 (칸반보드용)
  List<SubProject> findSubProjectsByStatus(String projectId, String status); 
}
