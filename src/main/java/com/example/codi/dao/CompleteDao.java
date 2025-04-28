package com.example.codi.dao;

import java.util.List;

public interface CompleteDao {
    void insertComplete(Complete complete);
    Complete getCompleteById(int completeId);
    List<Complete> getAllCompletes();
    List<Complete> getCompletesByWriterId(String writerId);
    void updateComplete(Complete complete);
    void deleteComplete(int completeId);
}
