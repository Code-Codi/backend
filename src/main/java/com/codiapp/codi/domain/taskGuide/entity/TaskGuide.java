package com.codiapp.codi.domain.taskGuide.entity;

import com.codiapp.codi.domain.taskGuide.dto.request.TaskGuideUpdateRequestDTO;
import com.codiapp.codi.domain.course.entity.Course;
import jakarta.persistence.Column;
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
import jakarta.persistence.CascadeType;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class TaskGuide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="course_id")
    private Course course;

    private String title;

    private LocalDateTime dueDate;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "taskGuide", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TaskGuideDetail> details = new ArrayList<>();

    public void updateTitle(String title) {
        this.title = title;
    }
    public void updateDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
    public void updateTaskGuide(TaskGuideUpdateRequestDTO request) {
        request.title().ifPresent(this::updateTitle);
        request.dueDate().ifPresent(this::updateDueDate);
    }

}
