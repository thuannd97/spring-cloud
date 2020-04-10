package com.thuannd.erm.model;

import java.io.Serializable;
import java.util.List;

public class ResponseDTO<T extends Serializable> implements Serializable{

    private static final long serialVersionUID = 1L;

    private List<T> t;
    private Long size;

    public ResponseDTO(List<T> t, Long size){
        this.t = t;
        this.size = size;
    }

    public List<T> getT() {
        return t;
    }

    public void setT(List<T> t) {
        this.t = t;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

}