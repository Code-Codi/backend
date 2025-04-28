package com.example.codi.controller;

//교수 컨트롤러
@RestController
@RequestMapping("/professors")
public class ProfessorController {
 private final CommentService commentService;

 public ProfessorController(CommentService commentService) {
     this.commentService = commentService;
 }

 @PostMapping("/comments")
 public ResponseEntity<Long> addComment(@RequestBody CommentDto commentDto) {
     return ResponseEntity.ok(commentService.addComment(commentDto));
 }

 @DeleteMapping("/comments/{commentId}")
 public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
     commentService.deleteComment(commentId);
     return ResponseEntity.ok().build();
 }
}
