package com.codiapp.codi.domain.board.dto.response;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PostResponseDTO {
    private Long id;
    private String title;
    private String content;
    private String boardType;
    private String teamName;
    private String type;
    private String thumbnail;
    private int visitors;
    private int favorites;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
