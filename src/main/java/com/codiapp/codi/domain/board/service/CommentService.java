package com.codiapp.codi.domain.board.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.codiapp.codi.domain.board.converter.CommentConverter;
import com.codiapp.codi.domain.board.dto.request.CreateCommentRequestDTO;
import com.codiapp.codi.domain.board.dto.response.CommentResponseDTO;
import com.codiapp.codi.domain.board.entity.Comment;
import com.codiapp.codi.domain.board.entity.Post;
import com.codiapp.codi.domain.board.repository.CommentRepository;
import com.codiapp.codi.domain.board.repository.PostRepository;
import com.codiapp.codi.global.apiPayload.code.status.ErrorStatus;
import com.codiapp.codi.global.apiPayload.exception.GeneralException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public Long createComment(Long postId, CreateCommentRequestDTO request) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.COMMENT_NOT_FOUND));

        Comment comment = CommentConverter.toComment(request, post);
        return commentRepository.save(comment).getId();
    }

    public List<CommentResponseDTO> getCommentsByPostId(Long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        return comments.stream()
                .map(CommentConverter::toCommentResponseDTO)
                .collect(Collectors.toList());
    }

    public void updateComment(Long postId, Long commentId, CreateCommentRequestDTO request) {
        Comment comment = commentRepository.findById(commentId)
            .orElseThrow(() -> new GeneralException(ErrorStatus.COMMENT_NOT_FOUND));

        if (!comment.getPost().getId().equals(postId)) {
            throw new GeneralException(ErrorStatus.COMMENT_NOT_FOUND);
        }

        comment.update(request.writerName(), request.content());
    }


   public void deleteComment(Long postId, Long commentId) {
        Comment comment = commentRepository.findById(commentId)
            .orElseThrow(() -> new GeneralException(ErrorStatus.COMMENT_NOT_FOUND));

        if (!comment.getPost().getId().equals(postId)) {
            throw new GeneralException(ErrorStatus.COMMENT_DELETE_FAIL);
        }
        
        commentRepository.delete(comment);
    }

}
