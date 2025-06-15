package com.codiapp.codi.domain.course.repository;

import com.codiapp.codi.domain.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
