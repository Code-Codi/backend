package com.codiapp.codi.domain.login.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.codiapp.codi.domain.login.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByEmail(String email);    
}
