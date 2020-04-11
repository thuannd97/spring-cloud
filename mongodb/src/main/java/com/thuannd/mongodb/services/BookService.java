package com.thuannd.mongodb.services;

import java.util.List;

import com.thuannd.mongodb.entities.Book;

public interface BookService {

    List<Book> findAll();

}