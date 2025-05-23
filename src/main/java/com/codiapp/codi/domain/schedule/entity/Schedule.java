package com.codiapp.codi.domain.schedule.entity;

import com.codiapp.codi.domain.team.entity.Team;
import com.codiapp.codi.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Schedule extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String title;

    @JoinColumn(name = "start_date")
    private LocalDateTime startDate;

    @JoinColumn(name = "end_date")
    private LocalDateTime endDate;

    @Column(length = 50, nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    public void updateSchedule(String title, LocalDateTime startDate, LocalDateTime endDate, String content) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.content = content;
    }
}