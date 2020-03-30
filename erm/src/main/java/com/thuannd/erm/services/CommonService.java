package com.thuannd.erm.services;

import java.util.List;

public interface CommonService<T>{

    void save(T t);

    void update(T t);

    void delete(T t);

    List<T> finAll();
}