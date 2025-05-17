package com.codiapp.codi.domain.meeting.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class AgendaDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agendaDetailId;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agenda_id")
    private Agenda agenda;

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }
}
