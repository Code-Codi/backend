package com.example.codi.dao;

import java.util.List;

public interface MeetingDecisionDAO {
    void insertDecision(MeetingDecision decision);
    void updateDecision(MeetingDecision decision);
    List<MeetingDecision> findDecisionsByMeetingId(Long meetingId);
    void deleteDecision(Long decisionId);
}
// 회의 결정사항(MeetingDecision) 등록, 수정, 조회, 삭제를 담당하는 DAO