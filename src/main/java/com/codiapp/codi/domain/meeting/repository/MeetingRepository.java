package com.codiapp.codi.domain.meeting.repository;

import com.codiapp.codi.domain.meeting.entity.Meeting;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
    Page<Meeting> findAllByTeamId(Long teamId, Pageable pageable);
}
