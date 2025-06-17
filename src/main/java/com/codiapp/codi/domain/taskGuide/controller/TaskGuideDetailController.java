package com.codiapp.codi.domain.taskGuide.controller;

import com.codiapp.codi.domain.taskGuide.dto.request.TaskGuideDetailCreateRequestDTO;
import com.codiapp.codi.domain.taskGuide.service.TaskGuideCommandService;
import com.codiapp.codi.domain.taskGuide.service.TaskGuideDetailCommandService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

}
