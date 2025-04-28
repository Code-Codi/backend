package com.example.codi.service;

import java.util.List;

import org.springframework.stereotype.Service;

//guide impl
@Service
public class GuideServiceImpl implements GuideService {
  private final GuideDAO guideDAO;
  private final MediaDAO mediaDAO;
  
  public GuideServiceImpl(GuideDAO guideDAO, MediaDAO mediaDAO) {
      this.guideDAO = guideDAO;
      this.mediaDAO = mediaDAO;
  }
  
  @Override
  public Long createGuide(GuideDto guideDto) {
      return guideDAO.insertGuide(guideDto);
  }
  
  @Override
  public void updateGuide(Long guideId, GuideDto guideDto) {
      guideDAO.updateGuide(guideDto);
  }
  
  @Override
  public void deleteGuide(Long guideId) {
      guideDAO.deleteGuide(guideId);
  }
  
  @Override
  public GuideDto getGuide(Long guideId) {
      return guideDAO.getGuideById(guideId);
  }
  
  @Override
  public List<GuideDto> getAllGuides() {
      return guideDAO.getAllGuides();
  }
}
