package com.thuannd.erm.model;

import java.io.Serializable;

public class UserDTO implements Serializable{

    private static final long serialVersionUID = 1L;
   
    private Long userId;
    private String username;
    private String password;
    private Integer status;
    private String fullName;
    private Integer gender;

    public UserDTO() {
    }

    public UserDTO(Long userId, String username, String password, Integer status, String fullName, Integer gender) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.status = status;
        this.fullName = fullName;
        this.gender = gender;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}