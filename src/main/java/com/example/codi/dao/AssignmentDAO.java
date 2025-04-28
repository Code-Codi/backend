package com.example.codi.dao;

import java.util.List;

public interface AssignmentDAO {
    void insertAssignment(Assignment assignment);
    void updateAssignment(Assignment assignment);
    Assignment findAssignmentById(Long assignmentId);
    List<Assignment> findAllAssignments();
    void deleteAssignment(Long assignmentId);
}
// 과제(Assignment) 정보 등록, 수정, 조회, 삭제를 담당하는 DAO