package com.example.codi.dao;

import java.util.List;

public interface MeetingDAO {
    void insertMeeting(Meeting meeting);
    void updateMeeting(Meeting meeting);
    Meeting findMeetingById(Long meetingId);
    List<Meeting> findAllMeetings();
    void deleteMeeting(Long meetingId);
}
// 회의록(Meeting) 정보 등록, 수정, 조회, 삭제를 담당하는 DAO
