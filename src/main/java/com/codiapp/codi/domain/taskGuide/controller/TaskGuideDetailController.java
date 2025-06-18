package com.codiapp.codi.domain.taskGuide.controller;

import com.codiapp.codi.domain.taskGuide.dto.request.TaskGuideDetailCreateRequestDTO;
import com.codiapp.codi.domain.taskGuide.dto.request.TaskGuideDetailUpdateRequestDTO;
import com.codiapp.codi.domain.taskGuide.service.TaskGuideDetailCommandService;
import io.swagger.v3.oas.annotations.Operation;
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
@RequiredArgsConstructor
@RequestMapping("/taskGuide-details")
public class TaskGuideDetailController {

    private final TaskGuideDetailCommandService taskGuideDetailCommandService;

    @Operation(summary = "세부 과제 제공 생성")
    @PostMapping
    public ResponseEntity<Long> createDetail(@RequestBody TaskGuideDetailCreateRequestDTO request) {
        return ResponseEntity.ok(taskGuideDetailCommandService.createTaskGuideDetail(request));
    }

    @PatchMapping("/{detailId}")
    @Operation(summary = "세부 과제 제공 수정")
    public ResponseEntity<Void> updateDetail(@PathVariable Long detailId, @RequestBody TaskGuideDetailUpdateRequestDTO request) {
        taskGuideDetailCommandService.updateTaskGuideDetail(detailId, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{detailId}")
    @Operation(summary = "세부 과제 제공 삭제")
    public ResponseEntity<Void> deleteDetail(@PathVariable Long detailId) {
        taskGuideDetailCommandService.deleteTaskGuideDetail(detailId);
        return ResponseEntity.noContent().build();
    }

}
