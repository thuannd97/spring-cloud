package com.thuannd.webflux.controllers;

import com.thuannd.webflux.entities.Book;
import com.thuannd.webflux.repositories.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ArticleController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public Flux<Book> findAllBook(){
        return bookRepository.findAll();
    }

    @PostMapping("/books")
    public Mono<Void> addBook(@RequestBody Book book){
        return bookRepository.save(book).then();
    }

    @DeleteMapping("/books/{id}")
    public Mono<Void> removeBook(@PathVariable(name = "id") String id){
        return bookRepository.deleteById(id);
    }

    @GetMapping("/books/{id}")
    public Mono<Book> findBookById(@PathVariable(name = "id") String id){
        return bookRepository.findById(id);
    }

}