package com.example.codi.controller;

//학생 컨트롤러
@RestController
@RequestMapping("/students")
public class StudentController {
 private final BookmarkService bookmarkService;
 private final CommentService commentService;

 public StudentController(BookmarkService bookmarkService, CommentService commentService) {
     this.bookmarkService = bookmarkService;
     this.commentService = commentService;
 }

 @PostMapping("/bookmarks")
 public ResponseEntity<Void> addBookmark(@RequestBody BookmarkDto bookmarkDto) {
     bookmarkService.addBookmark(bookmarkDto);
     return ResponseEntity.ok().build();
 }

 @GetMapping("/{studentId}/bookmarks")
 public ResponseEntity<List<GuideDto>> getBookmarks(@PathVariable String studentId) {
     return ResponseEntity.ok(bookmarkService.getBookmarks(studentId));
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
