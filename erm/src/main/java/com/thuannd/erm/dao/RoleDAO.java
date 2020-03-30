package com.thuannd.erm.dao;

import java.util.Optional;

import com.thuannd.erm.entities.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface RoleDAO extends JpaRepository<Role, Integer>{

    Optional<Role> findByRoleId(Integer roleId);

}