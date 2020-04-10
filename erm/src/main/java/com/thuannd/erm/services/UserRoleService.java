package com.thuannd.erm.services;

import java.util.List;

import com.thuannd.erm.model.UserRoleDTO;

public interface UserRoleService{

    List<UserRoleDTO> findAllRoleUser();

    Long countRoleUser();
}