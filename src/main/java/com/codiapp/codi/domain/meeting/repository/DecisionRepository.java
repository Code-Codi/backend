package com.codiapp.codi.domain.meeting.repository;

import com.codiapp.codi.domain.meeting.entity.Decision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DecisionRepository extends JpaRepository<Decision, Long> {
}
