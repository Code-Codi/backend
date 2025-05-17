package com.codiapp.codi.domain.meeting.repository;

import com.codiapp.codi.domain.meeting.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
}

