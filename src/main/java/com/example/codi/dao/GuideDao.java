package com.example.codi.dao;

import java.util.List;

public interface GuideDao {
    void insertGuide(Guide guide);
    Guide getGuideById(int guideId);
    List<Guide> getAllGuides();
    List<Guide> getGuidesByWriterId(String writerId);
    void updateGuide(Guide guide);
    void deleteGuide(int guideId);
}