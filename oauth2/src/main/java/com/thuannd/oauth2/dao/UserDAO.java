package com.thuannd.oauth2.dao;

import java.util.List;
import java.util.Optional;

import com.thuannd.oauth2.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long>{

    Optional<User> findByUsername(String username);

    List<User> findAll();

}