package com.example.codi.service;

import org.springframework.stereotype.Service;

//media impl
@Service
public class MediaServiceImpl implements MediaService {
  private final MediaDAO mediaDAO;
  
  public MediaServiceImpl(MediaDAO mediaDAO) {
      this.mediaDAO = mediaDAO;
  }
  
  @Override
  public Long uploadMedia(MultipartFile file, MediaDto mediaDto) {
      // TODO: 파일 정보 설정
      // TODO: 미디어 정보 저장
      return mediaDAO.insertMedia(mediaDto);
  }
  
  @Override
  public MediaDto getMedia(Long mediaId) {
      // TODO: 미디어 정보 조회
      return mediaDAO.getMediaById(mediaId);
  }
  
  @Override
  public void deleteMedia(Long mediaId) {
      // TODO: 미디어 정보 삭제
      mediaDAO.deleteMedia(mediaId);
  }
}