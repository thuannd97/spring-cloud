package com.thuannd.mongodb.services.impl;

import java.util.List;

import com.thuannd.mongodb.entities.Book;
import com.thuannd.mongodb.repositories.BookRepository;
import com.thuannd.mongodb.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

}