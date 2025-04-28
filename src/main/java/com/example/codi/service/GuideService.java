package com.example.codi.service;

import java.util.List;

//가이드 서비스
public interface GuideService {
  Long createGuide(GuideDto guideDto);
  void updateGuide(Long guideId, GuideDto guideDto);
  void deleteGuide(Long guideId);
  GuideDto getGuide(Long guideId);
  List<GuideDto> getAllGuides();
}