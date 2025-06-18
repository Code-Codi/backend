package com.codiapp.codi.domain.task.entity;

import com.codiapp.codi.domain.task.dto.request.TaskUpdateRequestDTO;
import com.codiapp.codi.domain.taskGuide.entity.TaskGuide;
import com.codiapp.codi.domain.team.entity.Team;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    private LocalDate taskDate;

    @Builder.Default
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TaskDetail> details = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taskGuide_id")
    private TaskGuide taskGuide;

    public void updateStatus(TaskStatus status) {
        this.status = status;
    }

    public void updateTaskDate(LocalDate taskDate) {
        this.taskDate = taskDate;
    }

    public void applyUpdate(TaskUpdateRequestDTO request) {
        request.status().ifPresent(this::updateStatus);
        request.taskDate().ifPresent(this::updateTaskDate);
    }
}
