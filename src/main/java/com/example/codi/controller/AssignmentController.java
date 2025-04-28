package com.example.codi.controller;

//과제 작성, 수정, 조회, 제출을 처리하는 컨트롤러
@RestController
@RequestMapping("/assignments")
public class AssignmentController {

 private final AssignmentService assignmentService;

 public AssignmentController(AssignmentService assignmentService) {
     this.assignmentService = assignmentService;
 }

 @PostMapping
 public ResponseEntity<Long> createAssignment(@RequestBody AssignmentDto assignmentDto) { }

 @PutMapping("/{assignmentId}")
 public ResponseEntity<Void> updateAssignment(@PathVariable Long assignmentId, @RequestBody AssignmentDto assignmentDto) { }

 @GetMapping("/{assignmentId}")
 public ResponseEntity<AssignmentDto> getAssignment(@PathVariable Long assignmentId) { }

 @GetMapping
 public ResponseEntity<List<AssignmentDto>> getAllAssignments() { }

 @PostMapping("/{assignmentId}/submit")
 public ResponseEntity<Void> submitAssignment(@PathVariable Long assignmentId, @RequestBody AssignmentSubmissionDto submissionDto) { }
}

