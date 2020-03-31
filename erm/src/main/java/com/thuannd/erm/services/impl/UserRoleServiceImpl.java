package com.thuannd.erm.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.thuannd.erm.dao.UserRoleDAO;
import com.thuannd.erm.entities.UserRole;
import com.thuannd.erm.model.UserRoleDTO;
import com.thuannd.erm.services.UserRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleDAO userRoleDAO; 

    @Override
    public List<UserRoleDTO> findAllRoleUser() {
        List<UserRole> userRoles = userRoleDAO.findAllRoleUser();
        List<UserRoleDTO> userRoleDTOs = new ArrayList<>();
        userRoles.forEach(ur ->{
            UserRoleDTO userRoleDTO = new UserRoleDTO();
            userRoleDTO.setUserRoleId(ur.getUserRoleId());
            userRoleDTO.setUserId(ur.getUserId());
            userRoleDTO.setRoleId(ur.getRoleId());
            userRoleDTO.setRoleStatus(ur.getRoleStatus());
            userRoleDTO.setUserStatus(ur.getUserStatus());
            userRoleDTO.setUsername(ur.getUsername());
            userRoleDTO.setFullname(ur.getFullname());
            userRoleDTOs.add(userRoleDTO);
        });
        return userRoleDTOs;
    }
    
}