package com.codiapp.codi.domain.project.controller;

import com.codiapp.codi.domain.project.dto.ExampleDTO;
import com.codiapp.codi.domain.project.service.ExampleQueryService;
import com.codiapp.codi.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
@RequiredArgsConstructor
public class ExampleController {
    private final ExampleQueryService exampleQueryService;

    @Operation(summary = "예시", description = "예시입니다")
    @GetMapping("")
    public ApiResponse<ExampleDTO.ExampleDetailDTO> getExample() {
        return ApiResponse.onSuccess(exampleQueryService.getExample());
    }
}
