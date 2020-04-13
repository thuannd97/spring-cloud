package com.thuannd.webflux.repositories;

import com.thuannd.webflux.entities.Book;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface BookRepository extends ReactiveCrudRepository<Book, String>{

}