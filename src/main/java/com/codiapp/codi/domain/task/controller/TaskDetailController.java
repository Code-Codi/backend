package com.codiapp.codi.domain.task.controller;

import com.codiapp.codi.domain.task.dto.request.TaskDetailCreateRequestDTO;
import com.codiapp.codi.domain.task.dto.request.TaskDetailUpdateRequestDTO;
import com.codiapp.codi.domain.task.service.TaskDetailCommandService;
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

    @PostMapping
    public ResponseEntity<Long> createDetail(@RequestBody TaskDetailCreateRequestDTO request) {
        return ResponseEntity.ok(taskDetailCommandService.createDetail(request));
    }

    @PatchMapping("/{detailId}")
    public ResponseEntity<Void> updateDetail(@PathVariable Long detailId,
                                             @RequestBody TaskDetailUpdateRequestDTO request) {
        taskDetailCommandService.updateDetail(detailId, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{detailId}")
    public ResponseEntity<Void> deleteDetail(@PathVariable Long detailId) {
        taskDetailCommandService.deleteDetail(detailId);
        return ResponseEntity.noContent().build();
    }
}

