package com.example.codi.dao;

import java.util.List;

public interface MediaDao {
    void insertMedia(Media media);
    Media getMediaById(int mediaId);
    List<Media> getMediaByGuideId(int guideId);
    List<Media> getMediaByCompleteId(int completeId);
    List<Media> getAllMedia();
    void deleteMedia(int mediaId);
}
