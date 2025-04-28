package com.example.codi.service;

import java.util.List;

//과제 관련 비즈니스 로직을 담당하는 서비스
public interface AssignmentService {

 Long createAssignment(AssignmentDto assignmentDto);

 void updateAssignment(Long assignmentId, AssignmentDto assignmentDto);

 AssignmentDto getAssignment(Long assignmentId);

 List<AssignmentDto> getAllAssignments();

 void submitAssignment(Long assignmentId, AssignmentSubmissionDto submissionDto);
}
