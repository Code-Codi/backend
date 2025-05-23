package com.codiapp.codi.domain.task.dto.request;

import com.codiapp.codi.domain.task.entity.TaskStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public record TaskUpdateRequestDTO(
        Optional<String> title,
        Optional<TaskStatus> status,
        Optional<LocalDate> taskDate
) {}
