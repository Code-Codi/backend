package com.codiapp.codi.domain.brief.controller;

import com.codiapp.codi.domain.brief.dto.request.BriefDetailCreateRequestDTO;
import com.codiapp.codi.domain.brief.dto.request.BriefDetailUpdateRequestDTO;
import com.codiapp.codi.domain.brief.service.BriefDetailCommandService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/taskGuide-details")
public class BriefDetailController {

    private final BriefDetailCommandService briefDetailCommandService;

    @Operation(summary = "세부 과제 제공 생성")
    @PostMapping
    public ResponseEntity<Long> createDetail(@RequestBody BriefDetailCreateRequestDTO request) {
        return ResponseEntity.ok(briefDetailCommandService.createBriefDetail(request));
    }

    @PatchMapping("/{briefDetailId}")
    @Operation(summary = "세부 과제 제공 수정")
    public ResponseEntity<Void> updateDetail(@PathVariable Long briefDetailId, @RequestBody BriefDetailUpdateRequestDTO request) {
        briefDetailCommandService.updateBriefDetail(briefDetailId, request);
        return ResponseEntity.ok().build();
    }

}
