package com.codiapp.codi.domain.project.repository.project;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codiapp.codi.domain.project.entity.project.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {


}
