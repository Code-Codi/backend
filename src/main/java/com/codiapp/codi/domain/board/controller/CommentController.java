package com.codiapp.codi.domain.board.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codiapp.codi.domain.board.dto.request.CreateCommentRequestDTO;
import com.codiapp.codi.domain.board.dto.response.CommentResponseDTO;
import com.codiapp.codi.domain.board.service.CommentService;
import com.codiapp.codi.global.apiPayload.ApiResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post/{postId}/comments")
public class CommentController {
 private final CommentService commentService;
 

    @PostMapping
    public ApiResponse<Long> createComment(@PathVariable Long postId, @RequestBody CreateCommentRequestDTO request) {
        return ApiResponse.onSuccess(commentService.createComment(postId, request));
    }

    @GetMapping
    public ApiResponse<List<CommentResponseDTO>> getComments(@PathVariable Long postId) {
        return ApiResponse.onSuccess(commentService.getCommentsByPostId(postId));
    }

    @PutMapping("/{commentId}")
    public ApiResponse<Void> updateComment(@PathVariable Long postId, @PathVariable Long commentId, @RequestBody CreateCommentRequestDTO request) {
        commentService.updateComment(postId, commentId, request);
        return ApiResponse.onSuccess(null);
    }

    @DeleteMapping("/{commentId}")
    public ApiResponse<Void> deleteComment(@PathVariable Long postId, @PathVariable Long commentId) {
        commentService.deleteComment(postId, commentId);
        return ApiResponse.onSuccess(null);
    }

}
