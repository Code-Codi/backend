package com.codiapp.codi.domain.meeting.repository;

import com.codiapp.codi.domain.meeting.entity.MeetingAttendee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingAttendeeRepository extends JpaRepository<MeetingAttendee, Long> {
}
