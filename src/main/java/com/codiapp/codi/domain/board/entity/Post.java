package com.codiapp.codi.domain.board.entity;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "POST")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_seq")
    @SequenceGenerator(name = "post_seq", sequenceName = "POST_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "WRITERID", nullable = false)
    private Long writerId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "CLOB")
    private String content;

    @Column(name = "CREATEDAT", nullable = false)
    private LocalDateTime createdAt;

    @Column
    private String state;

    @Column(name = "BOARD_TYPE")
    private String boardType;

    @Column(name = "TEAM_NAME")
    private String teamName;

    @Column(name = "TYPE")
    private String type;

    @Column
    @Builder.Default
    private Integer visitors = 0;

    @Column
    @Builder.Default
    private Integer favorites = 0;

    @Column(name = "THUMBNAIL_URL")
    private String thumbnailUrl;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
