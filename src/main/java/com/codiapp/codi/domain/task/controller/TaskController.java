package com.codiapp.codi.domain.task.controller;

import com.codiapp.codi.domain.task.dto.request.TaskCreateRequestDTO;
import com.codiapp.codi.domain.task.dto.request.TaskUpdateRequestDTO;
import com.codiapp.codi.domain.task.dto.response.TaskListResponseDTO;
import com.codiapp.codi.domain.task.dto.response.TaskResponseDTO;
import com.codiapp.codi.domain.task.service.TaskCommandService;
import com.codiapp.codi.domain.task.service.TaskQueryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskCommandService taskCommandService;
    private final TaskQueryService taskQueryService;

    @PostMapping
    @Operation(summary = "과제 생성")
    public ResponseEntity<Long> createTask(@RequestBody TaskCreateRequestDTO request) {
        Long taskId = taskCommandService.createTask(request);
        return ResponseEntity.ok(taskId);
    }

    @GetMapping("/{taskId}")
    @Operation(summary = "단일 과제 조회")
    public ResponseEntity<TaskResponseDTO> getTask(@PathVariable Long taskId) {
        TaskResponseDTO response = taskQueryService.getTask(taskId);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @Operation(summary = "전체 과제 리스트 조회")
    public ResponseEntity<Page<TaskListResponseDTO>> getAllTasks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<TaskListResponseDTO> response = taskQueryService.getAllTasks(pageable);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{taskId}")
    @Operation(summary = "과제 수정")
    public ResponseEntity<Void> updateTask(@PathVariable Long taskId, @RequestBody TaskUpdateRequestDTO request) {
        taskCommandService.updateTask(taskId, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{taskId}")
    @Operation(summary = "과제 삭제")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {
        taskCommandService.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }
}
