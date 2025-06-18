package com.codiapp.codi.domain.brief.entity;

import com.codiapp.codi.domain.brief.dto.request.BriefDetailUpdateRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class BriefDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="brief_id")
    private Brief brief;

    private String title;

    private String description;

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateDescription(String description) {
        this.description = description;
    }

    public void updateBriefDetail(BriefDetailUpdateRequestDTO request) {
        request.title().ifPresent(this::updateTitle);
        request.description().ifPresent(this::updateDescription);
    }

}
