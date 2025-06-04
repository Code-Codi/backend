package com.codiapp.codi.domain.board.converter;

import com.codiapp.codi.domain.board.dto.request.PostCreateRequestDTO;
import com.codiapp.codi.domain.board.dto.request.PostUpdateRequestDTO;
import com.codiapp.codi.domain.board.dto.response.PostResponseDTO;
import com.codiapp.codi.domain.board.dto.response.PostSimpleResponseDTO;
import com.codiapp.codi.domain.board.entity.Post;

public class PostConverter {
    public static Post toPost(PostCreateRequestDTO dto, String team) {
        return Post.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .boardType(dto.getBoardType())
                .type(dto.getType())
                .thumbnailUrl(dto.getThumbnail())
                .teamName(team)
                .writerId(dto.getWriterId())
                .build();
    }

    public static void updatePost(Post post, PostUpdateRequestDTO dto) {
        post.setTitle(dto.title());
        post.setContent(dto.content());
        post.setType(dto.type());
        post.setThumbnailUrl(dto.thumbnail());
    }

    public static PostResponseDTO toPostResponseDTO(Post post) {
        return PostResponseDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .type(post.getType())
                .thumbnail(post.getThumbnailUrl())
                .teamName(post.getTeamName())
                .visitors(post.getVisitors())
                .favorites(post.getFavorites())
                .createdAt(post.getCreatedAt())
                .build();
    }

    public static PostSimpleResponseDTO toPostSimpleResponseDTO(Post post) {
    return PostSimpleResponseDTO.builder()
            .id(post.getId())
            .title(post.getTitle())
            .writerId(post.getWriterId())
            .teamName(post.getTeamName())
            .type(post.getType())
            .visitors(post.getVisitors())
            .favorites(post.getFavorites())
            .createdAt(post.getCreatedAt())
            .thumbnail(post.getThumbnailUrl())
            .build();
}
}
