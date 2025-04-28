package com.example.codi.service;

import java.util.List;

import org.springframework.stereotype.Service;

//bookmark impl
@Service
public class BookmarkServiceImpl implements BookmarkService {
  private final BookmarkDAO bookmarkDAO;
  private final GuideDAO guideDAO;
  
  public BookmarkServiceImpl(BookmarkDAO bookmarkDAO, GuideDAO guideDAO) {
      this.bookmarkDAO = bookmarkDAO;
      this.guideDAO = guideDAO;
  }
  
  @Override
  public void addBookmark(BookmarkDto bookmarkDto) {
      bookmarkDAO.insertBookmark(bookmarkDto);
  }
  
  @Override
  public List<GuideDto> getBookmarks(String studentId) {
      List<Long> guideIds = bookmarkDAO.getBookmarkedGuideIds(studentId);
      return new ArrayList<>(); 
  }
}

