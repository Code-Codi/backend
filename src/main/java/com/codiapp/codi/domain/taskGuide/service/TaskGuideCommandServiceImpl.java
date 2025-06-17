package com.codiapp.codi.domain.taskGuide.service;

import com.codiapp.codi.domain.taskGuide.converter.TaskGuideConverter;
import com.codiapp.codi.domain.taskGuide.dto.request.TaskGuideCreateRequestDTO;
import com.codiapp.codi.domain.taskGuide.entity.TaskGuide;
import com.codiapp.codi.domain.taskGuide.repository.TaskGuideRepository;
import com.codiapp.codi.domain.user.entity.User;
import com.codiapp.codi.domain.user.repository.UserRepository;
import com.codiapp.codi.global.apiPayload.code.status.ErrorStatus;
import com.codiapp.codi.global.apiPayload.exception.handler.UserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskGuideCommandServiceImpl implements TaskGuideCommandService{

    private final TaskGuideRepository taskGuideRepository;
    private final UserRepository userRepository;

    @Override
    public Long createGuideTask(TaskGuideCreateRequestDTO request) {
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));

        TaskGuide taskGuide = TaskGuideConverter.toTaskGuide(request, user);
        return taskGuideRepository.save(taskGuide).getId();
    }

}
