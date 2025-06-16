package com.codiapp.codi.domain.team.repository;

import java.util.List;

import com.codiapp.codi.domain.course.entity.Course;
import com.codiapp.codi.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codiapp.codi.domain.team.entity.Team;
import com.codiapp.codi.domain.team.entity.UserTeam;

public interface UserTeamRepository extends JpaRepository<UserTeam, Long> {
	@Query("SELECT ut.team FROM UserTeam ut WHERE ut.user.id = :userId")
	List<Team> findTeamsByUserId(@Param("userId") Long userId);
	List<UserTeam> findByTeamId(Long teamId);
	boolean existsByUserAndTeam_Course(User user, Course course);
}
