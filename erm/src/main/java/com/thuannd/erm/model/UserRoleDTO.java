package com.thuannd.erm.model;

import java.io.Serializable;

public class UserRoleDTO implements Serializable{

    private static final long serialVersionUID = 1L;
   
    private Long userRoleId;
    private Long userId;
    private Integer roleId;
    private Integer isActive;

    public UserRoleDTO() {
    }

    public UserRoleDTO(Long userRoleId, Long userId, Integer roleId, Integer isActive) {
        this.userRoleId = userRoleId;
        this.userId = userId;
        this.roleId = roleId;
        this.isActive = isActive;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }
}