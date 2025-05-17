package com.codiapp.codi.domain.team.repository;

import com.codiapp.codi.domain.team.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
