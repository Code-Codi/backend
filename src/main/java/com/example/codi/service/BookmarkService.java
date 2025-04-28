package com.example.codi.service;

import java.util.List;

//북마크 서비스
public interface BookmarkService {
  void addBookmark(BookmarkDto bookmarkDto);
  List<GuideDto> getBookmarks(String studentId);
}
