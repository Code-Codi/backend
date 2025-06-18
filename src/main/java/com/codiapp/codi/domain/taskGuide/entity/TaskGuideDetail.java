package com.codiapp.codi.domain.taskGuide.entity;

import com.codiapp.codi.domain.task.entity.TaskDetail;
import com.codiapp.codi.domain.taskGuide.dto.request.TaskGuideDetailUpdateRequestDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class TaskGuideDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="taskGuide_id")
    private TaskGuide taskGuide;

    private String title;

    private String description;

    @OneToMany(mappedBy = "taskGuideDetail", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TaskDetail> taskDetails = new ArrayList<>();

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateDescription(String description) {
        this.description = description;
    }

    public void updateDetail(TaskGuideDetailUpdateRequestDTO request) {
        request.title().ifPresent(this::updateTitle);
        request.description().ifPresent(this::updateDescription);
    }

}
