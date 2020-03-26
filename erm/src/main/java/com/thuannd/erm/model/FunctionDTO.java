package com.thuannd.erm.model;

import java.io.Serializable;

public class FunctionDTO implements Serializable{

    private static final long serialVersionUID = 1L;
   
    private Long functionId;
    private String functionName;
    private Integer status;
    private String functionOrder;
    private String functionUrl;
    private String functionCode;
    private String description;

    public FunctionDTO() {
    }

    public FunctionDTO(Long functionId, String functionName, Integer status, String functionOrder, String functionUrl,
            String functionCode, String description) {
        this.functionId = functionId;
        this.functionName = functionName;
        this.status = status;
        this.functionOrder = functionOrder;
        this.functionUrl = functionUrl;
        this.functionCode = functionCode;
        this.description = description;
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