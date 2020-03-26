package com.thuannd.erm.model;

import java.io.Serializable;

public class RoleFunctionDTO implements Serializable{

    private static final long serialVersionUID = 1L;
   
    private Long roleFunctionId;
    private Integer roleId;
    private Long functionId;
    private Integer isActive;

    public RoleFunctionDTO() {
    }

    public RoleFunctionDTO(Long roleFunctionId, Integer roleId, Long functionId, Integer isActive) {
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