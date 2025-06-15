package com.codiapp.codi.domain.course.controller;

import com.codiapp.codi.domain.course.dto.CourseDetailResponseDTO;
import com.codiapp.codi.domain.course.service.CourseService;
import com.codiapp.codi.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    @GetMapping("")
    public ApiResponse<List<CourseDetailResponseDTO>> getCourseList() {
        return ApiResponse.onSuccess(courseService.getCourseList());
    }
}
