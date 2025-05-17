package com.codiapp.codi.domain.project.repository.project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codiapp.codi.domain.project.entity.project.Project;
import com.codiapp.codi.domain.project.entity.project.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {


}
