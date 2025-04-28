package com.example.codi.dao;

import java.util.List;

public interface MeetingAgendaDAO {
    void insertAgenda(MeetingAgenda agenda);
    void updateAgenda(MeetingAgenda agenda);
    List<MeetingAgenda> findAgendasByMeetingId(Long meetingId);
    void deleteAgenda(Long agendaId);
} 
// 회의 안건(MeetingAgenda) 등록, 수정, 조회, 삭제를 담당하는 DAO
