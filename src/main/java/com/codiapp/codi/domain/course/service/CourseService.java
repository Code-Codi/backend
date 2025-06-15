package com.codiapp.codi.domain.course.service;

import com.codiapp.codi.domain.course.dto.CourseDetailResponseDTO;

import java.util.List;

public interface CourseService {
    List<CourseDetailResponseDTO> getCourseList();
}
