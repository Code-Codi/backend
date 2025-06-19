package com.codiapp.codi.domain.meeting.repository;

import com.codiapp.codi.domain.meeting.entity.MeetingAttendee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetingAttendeeRepository extends JpaRepository<MeetingAttendee, Long> {
    List<MeetingAttendee> findByMeetingId(Long meetingId);
    void deleteAllByMeetingId(Long meetingId);
}
