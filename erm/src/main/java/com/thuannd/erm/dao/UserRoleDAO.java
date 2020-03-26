package com.thuannd.erm.dao;

import java.util.List;

import com.thuannd.erm.entities.Role;

public interface UserRoleDAO{

    List<Role> findAllRoleByUserId(Long userId);
    
}