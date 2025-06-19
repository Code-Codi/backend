package com.codiapp.codi.domain.board.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.codiapp.codi.domain.board.dto.request.PostCreateRequestDTO;
import com.codiapp.codi.domain.board.dto.request.PostUpdateRequestDTO;
import com.codiapp.codi.domain.board.dto.response.PostCreateResponseDTO;
import com.codiapp.codi.domain.board.dto.response.PostResponseDTO;
import com.codiapp.codi.domain.board.dto.response.PostSimpleResponseDTO;
import com.codiapp.codi.domain.board.service.PostService;
import com.codiapp.codi.global.apiPayload.ApiResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @GetMapping("/share/popular")
    public ApiResponse<List<PostSimpleResponseDTO>> getPopularPosts() {
        return ApiResponse.onSuccess(postService.getPopularPosts());
    }

    @PostMapping(value = "/posts", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
public ResponseEntity<ApiResponse<PostCreateResponseDTO>> createPost(
    @RequestPart("post") PostCreateRequestDTO postDto,
    @RequestPart(value = "image", required = false) MultipartFile imageFile
) {
    Long postId = postService.create(postDto, imageFile);
    return ResponseEntity.ok(ApiResponse.onSuccess(new PostCreateResponseDTO(postId)));
}


    // 게시글 상세 (타입 + ID)
    @GetMapping("/{boardType}/{postId}")
    public ApiResponse<PostResponseDTO> getPostByType(
        @PathVariable String boardType,
        @PathVariable Long postId) {
        return ApiResponse.onSuccess(postService.getPostByType(boardType, postId));
    }

    // 게시글 목록 (타입별)
    @GetMapping("/{boardType}")
    public ApiResponse<Page<PostSimpleResponseDTO>> getPostsByType(
        @PathVariable String boardType,
        Pageable pageable) {
        return ApiResponse.onSuccess(postService.getPostsByType(boardType, pageable));
    }

    @PutMapping("/{postId}")
    public ApiResponse<Void> updatePost(@PathVariable Long postId, @RequestBody PostUpdateRequestDTO request) {
        postService.updatePost(postId, request);
        return ApiResponse.onSuccess(null);
    }

    @DeleteMapping("/{postId}")
    public ApiResponse<Void> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return ApiResponse.onSuccess(null);
    }

    @PostMapping("/{postId}/favorite")
public ApiResponse<Void> favoritePost(@PathVariable Long postId) {
    postService.increaseFavorite(postId);
    return ApiResponse.onSuccess(null);
}

//조회수 증가
@PostMapping("/{postId}/view")
public ApiResponse<Void> increaseView(@PathVariable Long postId) {
    postService.increaseViewCount(postId);
    return ApiResponse.onSuccess(null);
}

} 
