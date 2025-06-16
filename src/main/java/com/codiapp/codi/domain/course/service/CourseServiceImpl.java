package com.codiapp.codi.domain.course.service;

import com.codiapp.codi.domain.course.converter.CourseConverter;
import com.codiapp.codi.domain.course.dto.CourseDetailResponseDTO;
import com.codiapp.codi.domain.course.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public List<CourseDetailResponseDTO> getCourseList() {
        return courseRepository.findAll().stream().map(CourseConverter::toCourseDetailResponseDTO).toList();
    }
}
