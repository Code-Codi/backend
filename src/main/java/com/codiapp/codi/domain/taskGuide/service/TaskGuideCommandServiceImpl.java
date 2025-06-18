package com.codiapp.codi.domain.taskGuide.service;

import com.codiapp.codi.domain.taskGuide.converter.TaskGuideConverter;
import com.codiapp.codi.domain.taskGuide.dto.request.TaskGuideCreateRequestDTO;
import com.codiapp.codi.domain.taskGuide.dto.request.TaskGuideUpdateRequestDTO;
import com.codiapp.codi.domain.taskGuide.entity.TaskGuide;
import com.codiapp.codi.domain.taskGuide.repository.TaskGuideRepository;
import com.codiapp.codi.domain.course.entity.Course;
import com.codiapp.codi.domain.course.repository.CourseRepository;
import com.codiapp.codi.global.apiPayload.code.status.ErrorStatus;
import com.codiapp.codi.global.apiPayload.exception.handler.TaskGuideHandler;
import com.codiapp.codi.global.apiPayload.exception.handler.CourseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TaskGuideCommandServiceImpl implements TaskGuideCommandService {

    private final TaskGuideRepository taskGuideRepository;
    private final CourseRepository courseRepository;

    @Override
    public Long createTaskGuide(TaskGuideCreateRequestDTO request) {
        Course course = courseRepository.findById(request.courseId())
                .orElseThrow(() -> new CourseHandler(ErrorStatus.COURSE_NOT_FOUND));

        TaskGuide taskGuide = TaskGuideConverter.toTaskGuide(request, course);
        return taskGuideRepository.save(taskGuide).getId();
    }

    @Transactional
    @Override
    public void updateTaskGuide(Long id, TaskGuideUpdateRequestDTO request) {
        TaskGuide taskGuide = taskGuideRepository.findById(id)
                .orElseThrow(()-> new TaskGuideHandler(ErrorStatus.TaskGuide_NOT_FOUND));

        taskGuide.updateTaskGuide(request);
    }

    @Override
    public void deleteTaskGuide(Long id) {
        TaskGuide taskGuide = taskGuideRepository.findById(id)
                .orElseThrow(()-> new TaskGuideHandler(ErrorStatus.TaskGuide_NOT_FOUND));

        taskGuideRepository.delete(taskGuide);
    }
}
