package com.codiapp.codi.domain.board.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.codiapp.codi.domain.board.converter.PostConverter;
import com.codiapp.codi.domain.board.dto.request.PostCreateRequestDTO;
import com.codiapp.codi.domain.board.dto.request.PostUpdateRequestDTO;
import com.codiapp.codi.domain.board.dto.response.PostResponseDTO;
import com.codiapp.codi.domain.board.dto.response.PostSimpleResponseDTO;
import com.codiapp.codi.domain.board.entity.Post;
import com.codiapp.codi.domain.board.repository.PostRepository;
import com.codiapp.codi.global.apiPayload.code.status.ErrorStatus;
import com.codiapp.codi.global.apiPayload.exception.GeneralException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Long createPost(PostCreateRequestDTO request) {
        Post post = PostConverter.toPost(request, request.getBoardType());
        return postRepository.save(post).getId();
    }

    public void updatePost(Long postId, PostUpdateRequestDTO request) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.POST_UPDATE_FAIL));
        PostConverter.updatePost(post, request);
    }

    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.POST_DELETE_FAIL));

        postRepository.delete(post);
    }

    public PostResponseDTO getPost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.POST_NOT_FOUND));

        return PostConverter.toPostResponseDTO(post);
    }

    public Page<PostSimpleResponseDTO> getPostList(Pageable pageable) {
        return postRepository.findAll(pageable)
                .map(PostConverter::toPostSimpleResponseDTO);
    }

    public Long create(PostCreateRequestDTO postDto, MultipartFile imageFile) {
    String imageUrl = null;
    if (imageFile != null && !imageFile.isEmpty()) {
        try {
            // 절대 경로 지정
            String uploadDir = System.getProperty("user.dir") + "/uploads";
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();  // 디렉토리 없으면 생성
            }

            String fileName = UUID.randomUUID() + "_" + imageFile.getOriginalFilename();
            File dest = new File(dir, fileName);
            imageFile.transferTo(dest);

            imageUrl = "/uploads/" + fileName;
        } catch (IOException e) {
            throw new RuntimeException("이미지 저장 실패", e);
        }
    }

    PostCreateRequestDTO updatedDto = PostCreateRequestDTO.builder()
        .title(postDto.getTitle())
        .content(postDto.getContent())
        .boardType(postDto.getBoardType())
        .teamName(postDto.getTeamName())
        .type(postDto.getType())
        .thumbnail(imageUrl)  
        .writerId(postDto.getWriterId())
        .build();
        
    return createPost(updatedDto);
}

public Page<PostSimpleResponseDTO> getPostsByType(String boardType, Pageable pageable) {
    return postRepository.findByBoardType(boardType.toUpperCase(), pageable)
                         .map(PostConverter::toPostSimpleResponseDTO);
}

    @Transactional
    public PostResponseDTO getPostByType(String boardType, Long postId) {
        Post post = postRepository.findByIdAndBoardType(postId, boardType.toUpperCase())
                .orElseThrow(() -> new GeneralException(ErrorStatus.POST_NOT_FOUND));
        post.setVisitors(post.getVisitors() + 1); // 방문자 수 증가
        return PostConverter.toPostResponseDTO(post);
    }

public List<PostSimpleResponseDTO> getPopularPosts() {
    List<Post> popularPosts = postRepository.findTop3ByOrderByVisitorsDesc();
    return popularPosts.stream()
        .map(PostConverter::toPostSimpleResponseDTO)
        .collect(Collectors.toList());
}

    public void increaseFavorite(Long postId) {
    Post post = postRepository.findById(postId)
        .orElseThrow(() -> new GeneralException(ErrorStatus.POST_NOT_FOUND));
    post.setFavorites(post.getFavorites() + 1);
    postRepository.save(post);
}


}
