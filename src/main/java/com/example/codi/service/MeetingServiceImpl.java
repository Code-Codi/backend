package com.example.codi.service;

import org.springframework.stereotype.Service;

//회의록 관련 비즈니스 로직 구현체
@Service
public class MeetingServiceImpl implements MeetingService {

 private final MeetingDAO meetingDAO;
 private final MeetingAgendaDAO meetingAgendaDAO;
 private final MeetingDecisionDAO meetingDecisionDAO;

 public MeetingServiceImpl(MeetingDAO meetingDAO, MeetingAgendaDAO meetingAgendaDAO, MeetingDecisionDAO meetingDecisionDAO) {
     this.meetingDAO = meetingDAO;
     this.meetingAgendaDAO = meetingAgendaDAO;
     this.meetingDecisionDAO = meetingDecisionDAO;
 }

 // 메소드 구현
}
