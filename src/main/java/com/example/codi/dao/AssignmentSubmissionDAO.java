package com.example.codi.dao;

import java.util.List;

public interface AssignmentSubmissionDAO {
    void submitAssignment(AssignmentSubmission submission);
    List<AssignmentSubmission> findSubmissionsByAssignmentId(Long assignmentId);
}
// 과제 제출(AssignmentSubmission) 등록 및 제출 내역 조회를 담당하는 DAO

