package com.thuannd.erm.dao;

import java.util.Optional;

import com.thuannd.erm.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserDAO extends JpaRepository<User, Long>{
    
    Optional<User> findByUsername(String username);

}