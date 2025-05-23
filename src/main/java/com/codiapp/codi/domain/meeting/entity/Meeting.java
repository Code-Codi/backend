package com.codiapp.codi.domain.meeting.entity;

import com.codiapp.codi.domain.team.entity.Team;
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
    private Long id;

    private String title;

    private LocalDateTime dateTime;

    private String location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;


    @OneToMany(mappedBy = "meeting", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Agenda> agendas = new ArrayList<>();

    @OneToMany(mappedBy = "meeting", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Decision> decisions = new ArrayList<>();

    public void addAgenda(Agenda agenda) {
        agendas.add(agenda);
        agenda.setMeeting(this);
    }

    public void addDecision(Decision decision) {
        decisions.add(decision);
        decision.setMeeting(this);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
