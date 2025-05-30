package com.codiapp.codi.domain.board.dto.response;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentResponseDTO {
    private Long id;
    private String writerName;
    private String content;
    private LocalDateTime createdAt;
}
