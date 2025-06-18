package com.codiapp.codi.domain.team.repository;

import com.codiapp.codi.domain.team.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
    List<Team> findAllByCourseId(Long courseId);
    List<Team> findByCourseId(Long courseId);
}
