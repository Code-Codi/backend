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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agenda_detail_seq_gen")
    @SequenceGenerator(name = "agenda_detail_seq_gen", sequenceName = "AGENDA_DETAIL_SEQ", allocationSize = 1)
    private Long id;

    @Lob
    @Column
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agenda_id")
    private Agenda agenda;

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }
}
