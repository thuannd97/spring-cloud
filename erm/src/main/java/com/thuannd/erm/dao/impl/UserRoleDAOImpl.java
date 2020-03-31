package com.thuannd.erm.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.thuannd.erm.dao.UserRoleDAO;
import com.thuannd.erm.entities.UserRole;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserRoleDAOImpl implements UserRoleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<String> findAllRoleByUserId(Long userId) {
        if (userId != null) {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT r.roleName FROM UserRole ur, Role r WHERE ur.roleId = r.roleId AND ur.roleId = :userId");
            Query query = entityManager.createQuery(sql.toString());
            query.setParameter("userId", userId.intValue());
            return query.getResultList();
        }
        return Collections.emptyList();
    }

    @Override
    public List<UserRole> findAllRoleUser() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT r.role_id, r.role_name, r.status, u.user_id, u.username, u.fullname, u.status FROM user_role ur, role r, user u WHERE ur.role_id = r.role_id AND ur.user_id = u.user_id and r.role_name LIKE '%USER%'");
        Query query = entityManager.createNativeQuery(sql.toString());
        List<Object[]> rows = query.getResultList();
        List<UserRole> userRoles = new ArrayList<>();
        for(Object[] row : rows){
            UserRole userRole = new UserRole();
            if(row[0] != null){
                userRole.setRoleId(Integer.parseInt(row[0].toString()));
            }
            if(row[1] != null){
                userRole.setRoleName(row[1].toString());
            }
            if(row[2] != null){
                userRole.setRoleStatus(Integer.parseInt(row[2].toString()));
            }
            if(row[3] != null){
                userRole.setUserId(Long.parseLong(row[3].toString()));
            }
            if(row[4] != null){
                userRole.setUsername(row[4].toString());
            }
            if(row[5] != null){
                userRole.setFullname(row[5].toString());
            }
            if(row[6] != null){
                userRole.setUserStatus(Integer.parseInt(row[6].toString()));
            }
            userRoles.add(userRole);
        }
        return userRoles;
    }

    @Override
    public Long countRoleUser() {
        return null;
    }

    

}