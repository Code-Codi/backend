package com.codiapp.codi.domain.board.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.codiapp.codi.domain.board.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

    // 게시판 타입별 게시글 목록 조회
    Page<Post> findByBoardType(String boardType, Pageable pageable);

    // 게시판 타입 + ID로 게시글 단건 조회
    Optional<Post> findByIdAndBoardType(Long id, String boardType);

    //조회수 기준 상위 3개 게시글 조회
    List<Post> findTop3ByBoardTypeOrderByVisitorsDesc(String boardType);  // ✅ 올바른 시그니처


}
