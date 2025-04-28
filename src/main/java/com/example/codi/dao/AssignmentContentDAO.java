package com.example.codi.dao;

import java.util.List;

public interface AssignmentContentDAO {
    void insertContent(AssignmentContent content);
    void updateContent(AssignmentContent content);
    List<AssignmentContent> findContentsByAssignmentId(Long assignmentId);
    void deleteContent(Long contentId);
}
// 과제 상세 내용(AssignmentContent) 등록, 수정, 조회, 삭제를 담당하는 DAO
