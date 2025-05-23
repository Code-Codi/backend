package com.codiapp.codi.domain.task.entity;

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

    private String title;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    private LocalDate taskDate;

    @Builder.Default
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TaskDetail> details = new ArrayList<>();

    public void addDetail(TaskDetail detail) {
        details.add(detail);
        detail.setTask(this);
    }

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateStatus(TaskStatus status) {
        this.status = status;
    }

    public void updateTaskDate(LocalDate taskDate) {
        this.taskDate = taskDate;
    }

    public void clearDetails() {
        this.details.clear();
    }
}
