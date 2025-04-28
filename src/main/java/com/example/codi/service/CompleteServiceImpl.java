package com.example.codi.service;

import org.springframework.stereotype.Service;

//complete impl
@Service
public class CompleteServiceImpl implements CompleteService {
  private final CompleteDAO completeDAO;
  private final MediaDAO mediaDAO;
  
  public CompleteServiceImpl(CompleteDAO completeDAO, MediaDAO mediaDAO) {
      this.completeDAO = completeDAO;
      this.mediaDAO = mediaDAO;
  }
  
  @Override
  public Long createComplete(CompleteDto completeDto) {
      return completeDAO.insertComplete(completeDto);
  }
  
  @Override
  public void deleteComplete(Long completeId) {
      completeDAO.deleteComplete(completeId);
  }
  
  @Override
  public CompleteDto getComplete(Long completeId) {
      return completeDAO.getCompleteById(completeId);
  }
  
  @Override
  public List<CompleteDto> getAllCompletes() {
      return completeDAO.getAllCompletes();
  }
}
