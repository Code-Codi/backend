package com.codiapp.codi.domain.brief.repository;

import com.codiapp.codi.domain.brief.entity.Brief;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BriefRepository extends JpaRepository<Brief, Long> {
}
