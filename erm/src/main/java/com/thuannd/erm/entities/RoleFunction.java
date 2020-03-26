package com.thuannd.erm.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role_function")
public class RoleFunction implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_function_id")
    private Long roleFunctionId;
    @Column(name = "role_id")
    private Integer roleId;
    @Column(name = "function_id")
    private Long functionId;
    @Column(name = "is_active")
    private Integer isActive;

    public RoleFunction() {
    }

    public RoleFunction(Long roleFunctionId, Integer roleId, Long functionId, Integer isActive) {
        this.roleFunctionId = roleFunctionId;
        this.roleId = roleId;
        this.functionId = functionId;
        this.isActive = isActive;
    }

    public Long getRoleFunctionId() {
        return roleFunctionId;
    }

    public void setRoleFunctionId(Long roleFunctionId) {
        this.roleFunctionId = roleFunctionId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Long getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Long functionId) {
        this.functionId = functionId;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }
}