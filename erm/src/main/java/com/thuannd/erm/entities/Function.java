package com.thuannd.erm.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "function")
public class Function implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "function_id")
    private Long functionId;
    @Column(name = "function_name")
    private String functionName;
    @Column(name = "status")
    private Integer status;
    @Column(name = "function_order")
    private String functionOrder;
    @Column(name = "function_url")
    private String functionUrl;
    @Column(name = "function_code")
    private String functionCode;
    @Column(name = "description")
    private String description;

    public Function() {
    }

    public Function(Long functionId, String functionName, Integer status, String functionOrder, String functionUrl,
            String functionCode, String description) {
        this.functionId = functionId;
        this.functionName = functionName;
        this.status = status;
        this.functionOrder = functionOrder;
        this.functionUrl = functionUrl;
        this.functionCode = functionCode;
        this.description = description;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Long functionId) {
        this.functionId = functionId;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFunctionOrder() {
        return functionOrder;
    }

    public void setFunctionOrder(String functionOrder) {
        this.functionOrder = functionOrder;
    }

    public String getFunctionUrl() {
        return functionUrl;
    }

    public void setFunctionUrl(String functionUrl) {
        this.functionUrl = functionUrl;
    }

    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}