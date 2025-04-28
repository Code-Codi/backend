package com.example.codi.service;

//댓글 서비스
public interface CommentService {
  Long addComment(CommentDto commentDto);
  void deleteComment(Long commentId);
}
