package com.example.codi.service;

import org.springframework.stereotype.Service;

//comment impl
@Service
public class CommentServiceImpl implements CommentService {
  private final CommentDAO commentDAO;
  
  public CommentServiceImpl(CommentDAO commentDAO) {
      this.commentDAO = commentDAO;
  }
  
  @Override
  public Long addComment(CommentDto commentDto) {
      return commentDAO.insertComment(commentDto);
  }
  
  @Override
  public void deleteComment(Long commentId) {
      commentDAO.deleteComment(commentId);
  }
}
