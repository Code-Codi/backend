package com.example.codi.service;

import java.util.List;

//회의록 관련 비즈니스 로직을 담당하는 서비스
public interface MeetingService {

 Long createMeeting(MeetingDto meetingDto);

 void updateMeeting(Long meetingId, MeetingDto meetingDto);

 MeetingDto getMeeting(Long meetingId);

 List<MeetingDto> getAllMeetings();
}