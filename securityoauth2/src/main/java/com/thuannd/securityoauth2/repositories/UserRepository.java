package com.thuannd.securityoauth2.repositories;

import java.util.Optional;

import com.thuannd.securityoauth2.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByUsername(String username);

}