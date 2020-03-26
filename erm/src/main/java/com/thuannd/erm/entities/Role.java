package com.thuannd.erm.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role implements Serializable{
   
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "status")
    private Integer status;
    @Column(name = "description")
    private String description;
    @Column(name = "role_code")
    private String roleCode;
    @Column(name = "role_order")
    private String roleOrder;

    public Role() {
    }

    public Role(Integer roleId, String roleName, Integer status, String description, String roleCode,
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