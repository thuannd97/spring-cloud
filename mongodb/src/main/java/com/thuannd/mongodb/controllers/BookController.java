package com.thuannd.mongodb.controllers;

import java.util.List;

import com.thuannd.mongodb.entities.Book;
import com.thuannd.mongodb.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> findAll(){
        return bookService.findAll();
    }

}