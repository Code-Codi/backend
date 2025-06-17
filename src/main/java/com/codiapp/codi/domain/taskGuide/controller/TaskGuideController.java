package com.codiapp.codi.domain.taskGuide.controller;

import com.codiapp.codi.domain.taskGuide.dto.request.TaskGuideCreateRequestDTO;
import com.codiapp.codi.domain.taskGuide.dto.response.TaskGuideResponseDTO;
import com.codiapp.codi.domain.taskGuide.service.TaskGuideCommandService;
import com.codiapp.codi.domain.taskGuide.service.TaskGuideQueryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasksGuides")
@RequiredArgsConstructor
public class TaskGuideController {

    private final TaskGuideQueryService taskGuideQueryService;
    private final TaskGuideCommandService taskGuideCommandService;

    @GetMapping("/{taskGuideId}")
    @Operation(summary = "단일 과제 제공 조회")
    public ResponseEntity<TaskGuideResponseDTO> getTaskGuide(@PathVariable Long taskGuideId) {
        TaskGuideResponseDTO response = taskGuideQueryService.getTaskGuide(taskGuideId);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    @Operation(summary = "과제 제공 생성")
    public ResponseEntity<Long> createTaskGuide(@RequestBody TaskGuideCreateRequestDTO request) {
        Long taskGuideId = taskGuideCommandService.createGuideTask(request);
        return ResponseEntity.ok(taskGuideId);
    }
}
