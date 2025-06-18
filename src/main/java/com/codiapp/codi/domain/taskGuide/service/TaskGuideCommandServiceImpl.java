package com.codiapp.codi.domain.taskGuide.service;

import com.codiapp.codi.domain.task.entity.Task;
import com.codiapp.codi.domain.task.entity.TaskDetail;
import com.codiapp.codi.domain.task.entity.TaskStatus;
import com.codiapp.codi.domain.task.repository.TaskRepository;
import com.codiapp.codi.domain.taskGuide.converter.TaskGuideConverter;
import com.codiapp.codi.domain.taskGuide.dto.request.TaskGuideCreateRequestDTO;
import com.codiapp.codi.domain.taskGuide.dto.request.TaskGuideUpdateRequestDTO;
import com.codiapp.codi.domain.taskGuide.entity.TaskGuide;
import com.codiapp.codi.domain.taskGuide.entity.TaskGuideDetail;
import com.codiapp.codi.domain.taskGuide.repository.TaskGuideRepository;
import com.codiapp.codi.domain.course.entity.Course;
import com.codiapp.codi.domain.course.repository.CourseRepository;
import com.codiapp.codi.domain.team.entity.Team;
import com.codiapp.codi.domain.team.repository.TeamRepository;
import com.codiapp.codi.global.apiPayload.code.status.ErrorStatus;
import com.codiapp.codi.global.apiPayload.exception.handler.TaskGuideHandler;
import com.codiapp.codi.global.apiPayload.exception.handler.CourseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskGuideCommandServiceImpl implements TaskGuideCommandService {

    private final TaskGuideRepository taskGuideRepository;
    private final CourseRepository courseRepository;
    private final TeamRepository teamRepository;
    private final TaskRepository taskRepository;

    @Transactional
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

    @Transactional
    @Override
    public void generateTasks(Long taskGuideId) {
        TaskGuide guide = taskGuideRepository.findById(taskGuideId)
                .orElseThrow(() -> new TaskGuideHandler(ErrorStatus.TaskGuide_NOT_FOUND));
        createEmptyTasksForTeams(guide);
    }

    public void createEmptyTasksForTeams(TaskGuide guide) {
        List<Team> teams = teamRepository.findAllByCourseId(guide.getCourse().getId());

        for (Team team : teams) {
            Task task = Task.builder()
                    .team(team)
                    .taskGuide(guide)
                    .status(TaskStatus.IN_PROGRESS) // 처음엔 제출 전 상태
                    .build();

            for (TaskGuideDetail guideDetail : guide.getDetails()) {
                TaskDetail detail = TaskDetail.builder()
                        .task(task)
                        .taskGuideDetail(guideDetail)
                        .content("") // 초기엔 빈칸
                        .build();
                task.getDetails().add(detail); // 양방향 연관관계 설정
            }

            taskRepository.save(task); // cascade로 detail도 저장됨
        }
    }
}
