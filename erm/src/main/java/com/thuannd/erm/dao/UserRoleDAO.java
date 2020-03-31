package com.thuannd.erm.dao;

import java.util.List;

import com.thuannd.erm.entities.UserRole;

public interface UserRoleDAO{

    List<String> findAllRoleByUserId(Long userId);
    
    List<UserRole> findAllRoleUser();

    Long countRoleUser();
}