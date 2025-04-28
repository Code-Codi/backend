package com.example.codi.service;

import java.util.List;

//완성본 서비스
public interface CompleteService {
  Long createComplete(CompleteDto completeDto);
  void deleteComplete(Long completeId);
  CompleteDto getComplete(Long completeId);
  List<CompleteDto> getAllCompletes();
}