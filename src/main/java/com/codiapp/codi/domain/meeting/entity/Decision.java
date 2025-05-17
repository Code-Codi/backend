package com.codiapp.codi.domain.meeting.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Decision {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "decision_seq_gen")
    @SequenceGenerator(name = "decision_seq_gen", sequenceName = "DECISION_SEQ", allocationSize = 1)
    private Long id;

    @Lob
    @Column
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }
}
