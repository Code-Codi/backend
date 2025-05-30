package com.codiapp.codi.domain.board.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateCommentRequestDTO(
    @NotNull Long postId,
    @NotBlank String writerName,
    @NotBlank String content
) {
    
}
