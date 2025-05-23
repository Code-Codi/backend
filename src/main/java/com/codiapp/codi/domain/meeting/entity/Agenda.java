package com.codiapp.codi.domain.meeting.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

    @OneToMany(mappedBy = "agenda", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<AgendaDetail> details = new ArrayList<>();

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }

    public void addDetail(AgendaDetail detail) {
        details.add(detail);
        detail.setAgenda(this);
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
