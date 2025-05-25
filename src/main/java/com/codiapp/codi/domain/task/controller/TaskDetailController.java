package com.codiapp.codi.domain.task.controller;

import com.codiapp.codi.domain.task.dto.request.TaskDetailCreateRequestDTO;
import com.codiapp.codi.domain.task.dto.request.TaskDetailUpdateRequestDTO;
import com.codiapp.codi.domain.task.service.TaskDetailCommandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task-details")
@RequiredArgsConstructor
public class TaskDetailController {

    private final TaskDetailCommandService taskDetailCommandService;

    @Operation(summary = "세부 작업 생성", description = "새로운 세부 작업(TaskDetail)을 생성합니다.")
    @PostMapping
    public ResponseEntity<Long> createDetail(@RequestBody TaskDetailCreateRequestDTO request) {
        return ResponseEntity.ok(taskDetailCommandService.createDetail(request));
    }

    @Operation(summary = "세부 작업 수정", description = "기존 세부 작업(TaskDetail)을 수정합니다.")
    @PatchMapping("/{detailId}")
    public ResponseEntity<Void> updateDetail(@Parameter(description = "수정할 세부 작업 ID", example = "1")
                                             @PathVariable Long detailId,
                                             @RequestBody TaskDetailUpdateRequestDTO request) {
        taskDetailCommandService.updateDetail(detailId, request);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "세부 작업 삭제", description = "세부 작업(TaskDetail)을 삭제합니다.")
    @DeleteMapping("/{detailId}")
    public ResponseEntity<Void> deleteDetail(
            @Parameter(description = "삭제할 세부 작업 ID", example = "1")
            @PathVariable Long detailId) {
        taskDetailCommandService.deleteDetail(detailId);
        return ResponseEntity.noContent().build();
    }
}

