package com.codiapp.codi.domain.meeting.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String title;

    private LocalDateTime dateTime;

    private String location;

    @OneToMany(mappedBy = "meeting", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Agenda> agendas = new ArrayList<>();

    @OneToMany(mappedBy = "meeting", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Decision> decisions = new ArrayList<>();

    public void addAgenda(Agenda agenda) {
        agendas.add(agenda);
        agenda.setMeeting(this);
    }

    public void addDecision(Decision decision) {
        decisions.add(decision);
        decision.setMeeting(this);
    }

    public void update(String title, LocalDateTime dateTime, String location) {
        this.title = title;
        this.dateTime = dateTime;
        this.location = location;
    }
}
