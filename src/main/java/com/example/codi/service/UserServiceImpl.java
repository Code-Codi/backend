package com.example.codi.service;

import java.util.List;

import org.springframework.stereotype.Service;

//user impl
@Service
public class UserServiceImpl implements UserService {
  private final UserDAO userDAO;
  private final SessionDAO sessionDAO;
  
  public UserServiceImpl(UserDAO userDAO, SessionDAO sessionDAO) {
      this.userDAO = userDAO;
      this.sessionDAO = sessionDAO;
  }
  
  @Override
  public Long createUser(UserDto userDto) {
      return userDAO.insertUser(userDto);
  }
  
  @Override
  public void updateUser(String userId, UserDto userDto) {
      userDAO.updateUser(userId, userDto);
  }
  
  @Override
  public UserDto getUser(String userId) {
      return userDAO.getUserByUserId(userId);
  }
  
  @Override
  public UserSessionDto login(LoginDto loginDto) {
      return new UserSessionDto(); 
  }
  
  @Override
  public void logout(String userId) {
      sessionDAO.removeSessionByUserId(userId);
  }
}