package com.example.codi.service;

//계정 서비스
public interface UserService {
  Long createUser(UserDto userDto);
  void updateUser(String userId, UserDto userDto);
  UserDto getUser(String userId);
  UserSessionDto login(LoginDto loginDto);
  void logout(String userId);
}
