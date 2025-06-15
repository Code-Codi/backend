package com.codiapp.codi.domain.course.converter;

import com.codiapp.codi.domain.course.dto.CourseDetailResponseDTO;
import com.codiapp.codi.domain.course.entity.Course;

public class CourseConverter {
    public static CourseDetailResponseDTO toCourseDetailResponseDTO(Course course) {
        return CourseDetailResponseDTO.builder()
                .id(course.getId())
                .name(course.getName())
                .build();
    }
}
