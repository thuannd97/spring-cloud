package com.thuannd.erm.dao;

import java.util.List;

public interface UserRoleDAO{

    List<String> findAllRoleByUserId(Long userId);
    
}