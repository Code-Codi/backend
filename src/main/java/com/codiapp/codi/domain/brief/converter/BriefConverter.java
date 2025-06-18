package com.codiapp.codi.domain.brief.converter;

import com.codiapp.codi.domain.brief.dto.request.BriefCreateRequestDTO;
import com.codiapp.codi.domain.brief.dto.request.BriefDetailCreateRequestDTO;
import com.codiapp.codi.domain.brief.dto.response.BriefDetailResponseDTO;
import com.codiapp.codi.domain.brief.dto.response.BriefResponseDTO;
import com.codiapp.codi.domain.brief.entity.Brief;
import com.codiapp.codi.domain.brief.entity.BriefDetail;
import com.codiapp.codi.domain.course.entity.Course;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class BriefConverter {

    //단일 조회
    public static BriefResponseDTO toTaskGuideResponeDTO(Brief brief) {
        List<BriefDetailResponseDTO> detailDTOs = brief.getDetails().stream()
                .map(d-> new BriefDetailResponseDTO(d.getId(), d.getTitle(), d.getDescription()))
                .collect(Collectors.toList());

        return new BriefResponseDTO(
                brief.getId(),
                brief.getTitle(),
                brief.getDueDate(),
                brief.getCreatedAt(),
                detailDTOs
        );
    }

    //dto-> entity
    public static Brief toTaskGuide(BriefCreateRequestDTO request, Course course) {
        Brief brief = Brief.builder()
                .title(request.title())
                .dueDate(request.dueDate())
                .createdAt(LocalDateTime.now())
                .course(course)
                .build();
        return brief;
    }

    public static BriefDetail toTaskGuideDetail(BriefDetailCreateRequestDTO request, Brief brief) {
        return BriefDetail.builder()
                .title(request.title())
                .description(request.description())
                .brief(brief)
                .build();
    }
}
