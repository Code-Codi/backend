package com.example.codi.service;

//미디어 서비스
public interface MediaService {
  Long uploadMedia(MultipartFile file, MediaDto mediaDto);
  MediaDto getMedia(Long mediaId);
  void deleteMedia(Long mediaId);
}
