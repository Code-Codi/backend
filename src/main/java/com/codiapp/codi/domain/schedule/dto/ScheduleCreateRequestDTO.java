package com.codiapp.codi.domain.schedule.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record ScheduleCreateRequestDTO(
        @NotNull(message = "팀 ID는 필수입니다.")
        Long teamId,

        @NotBlank(message = "제목은 필수 입력 사항입니다.")
        @Size(max = 20, message = "제목은 최대 20자까지 입력할 수 있습니다.")
        String title,

        @NotNull(message = "시작 날짜는 필수입니다.")
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime startDate,

        @NotNull(message = "종료 날짜는 필수입니다.")
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime endDate,

        @NotBlank(message = "내용은 필수 입력 사항입니다.")
        @Size(max = 50, message = "내용은 최대 50자까지 입력할 수 있습니다.")
        String content
) {
}
