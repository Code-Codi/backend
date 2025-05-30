package com.codiapp.codi.domain.board.dto.response;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostSimpleResponseDTO {
    private Long id;
    private String title;
    private Long writerId;
    private String teamName;
    private String type;
    private int visitors;
    private int favorites;
    private LocalDateTime createdAt;
}
