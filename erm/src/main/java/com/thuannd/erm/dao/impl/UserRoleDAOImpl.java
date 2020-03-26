package com.thuannd.erm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.thuannd.erm.dao.UserRoleDAO;
import com.thuannd.erm.entities.Role;

import org.springframework.stereotype.Repository;

@Repository
public class UserRoleDAOImpl implements UserRoleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> findAllRoleByUserId(Long userId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT r.role_id, r.role_code, r.role_name FROM user_role ur, role r WHERE ur.role_id = r.role_id AND ur.role_id = :userId");
        Query query = entityManager.createQuery(sql.toString());
        query.setParameter("userId", userId);
        return query.getResultList() != null ? query.getResultList() : new ArrayList<>();
    }

    

}