package com.codiapp.codi.domain.meeting.repository;

import com.codiapp.codi.domain.meeting.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
}
