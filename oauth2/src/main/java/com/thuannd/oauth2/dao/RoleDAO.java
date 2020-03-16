package com.thuannd.oauth2.dao;

import java.util.Optional;

import com.thuannd.oauth2.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role, Integer>{
    
    Optional<Role> findByRoleId(Long id);
    
}