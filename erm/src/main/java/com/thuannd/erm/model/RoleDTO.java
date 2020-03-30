package com.thuannd.erm.model;

import java.io.Serializable;

public class RoleDTO implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Integer roleId;
    private String roleName;
    private Integer status;
    private String description;
    private String roleCode;
    private String roleOrder;

    public RoleDTO() {
    }

    public RoleDTO(Integer roleId, String roleName, Integer status, String description, String roleCode,
            String roleOrder) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.status = status;
        this.description = description;
        this.roleCode = roleCode;
        this.roleOrder = roleOrder;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleOrder() {
        return roleOrder;
    }

    public void setRoleOrder(String roleOrder) {
        this.roleOrder = roleOrder;
    }
}
