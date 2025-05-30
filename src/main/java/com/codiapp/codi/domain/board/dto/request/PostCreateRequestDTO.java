package com.codiapp.codi.domain.board.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateRequestDTO {
    private String title;
    private String content;
    private String boardType;
    private String teamName;
    private String type;
    private String thumbnail;
    private Long writerId;
}

