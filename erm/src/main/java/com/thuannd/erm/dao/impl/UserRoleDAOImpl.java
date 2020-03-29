package com.thuannd.erm.dao.impl;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.thuannd.erm.dao.UserRoleDAO;

import org.springframework.stereotype.Repository;

@Repository
public class UserRoleDAOImpl implements UserRoleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<String> findAllRoleByUserId(Long userId) {
        if(userId != null){
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT r.roleName FROM UserRole ur, Role r WHERE ur.roleId = r.roleId AND ur.roleId = :userId");
            Query query = entityManager.createQuery(sql.toString());
            query.setParameter("userId", userId.intValue());
            return query.getResultList();
        }
        return Collections.emptyList();
    }

    

}