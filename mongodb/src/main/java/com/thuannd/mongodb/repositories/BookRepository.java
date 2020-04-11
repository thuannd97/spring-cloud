package com.thuannd.mongodb.repositories;

import com.thuannd.mongodb.entities.Book;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String>{

}