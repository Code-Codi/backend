package com.codiapp.codi.domain.board.converter;

import java.time.LocalDateTime;

import com.codiapp.codi.domain.board.dto.request.CreateCommentRequestDTO;
import com.codiapp.codi.domain.board.dto.response.CommentResponseDTO;
import com.codiapp.codi.domain.board.entity.Comment;
import com.codiapp.codi.domain.board.entity.Post;

public class CommentConverter {
    public static Comment toComment(CreateCommentRequestDTO dto, Post post) {
        return Comment.builder()
                .writerName(dto.writerName())
                .content(dto.content())
                .post(post)
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static CommentResponseDTO toCommentResponseDTO(Comment comment) {
        return CommentResponseDTO.builder()
                .id(comment.getId())
                .writerName(comment.getWriterName())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .build();
    }
}
