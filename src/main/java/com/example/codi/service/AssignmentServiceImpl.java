package com.example.codi.service;

import org.springframework.stereotype.Service;

//과제 관련 비즈니스 로직 구현체
@Service
public class AssignmentServiceImpl implements AssignmentService {

 private final AssignmentDAO assignmentDAO;
 private final AssignmentContentDAO assignmentContentDAO;
 private final AssignmentSubmissionDAO assignmentSubmissionDAO;

 public AssignmentServiceImpl(AssignmentDAO assignmentDAO, AssignmentContentDAO assignmentContentDAO, AssignmentSubmissionDAO assignmentSubmissionDAO) {
     this.assignmentDAO = assignmentDAO;
     this.assignmentContentDAO = assignmentContentDAO;
     this.assignmentSubmissionDAO = assignmentSubmissionDAO;
 }

 // 메소드 구현
}
