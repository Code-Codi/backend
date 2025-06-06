package com.codiapp.codi.domain.team.entity;

import com.codiapp.codi.domain.schedule.entity.Schedule;
import com.codiapp.codi.global.common.BaseEntity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Team extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    public void updateName(String name) {
    	this.name = name;
    }
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Schedule> scheduleList = new ArrayList<>();
    
    
}