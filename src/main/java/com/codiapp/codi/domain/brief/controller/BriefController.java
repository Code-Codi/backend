package com.codiapp.codi.domain.brief.controller;

import com.codiapp.codi.domain.brief.dto.request.BriefCreateRequestDTO;
import com.codiapp.codi.domain.brief.dto.response.BriefResponseDTO;
import com.codiapp.codi.domain.brief.service.BriefCommandService;
import com.codiapp.codi.domain.brief.service.BriefQueryService;
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
@RequestMapping("/Brief")
@RequiredArgsConstructor
public class BriefController {

    private final BriefQueryService briefQueryService;
    private final BriefCommandService briefCommandService;

    @GetMapping("/{briefId}")
    @Operation(summary = "단일 과제 제공 조회")
    public ResponseEntity<BriefResponseDTO> getBrief(@PathVariable Long briefId) {
        BriefResponseDTO response = briefQueryService.getBrief(briefId);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    @Operation(summary = "과제 제공 생성")
    public ResponseEntity<Long> createBrief(@RequestBody BriefCreateRequestDTO request) {
        Long briefId = briefCommandService.createBrief(request);
        return ResponseEntity.ok(briefId);
    }
}
