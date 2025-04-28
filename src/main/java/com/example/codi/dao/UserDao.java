package com.example.codi.dao;

import java.util.List;

public interface UserDao {
    void insertUser(User user);
    User getUserById(Long id);
    User getUserByEmail(String email);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(Long id);
}
