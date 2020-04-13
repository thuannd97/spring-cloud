package com.thuannd.webflux.entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Book implements Serializable{

    private static final long serialVersionUID = 1L;
   
    @Id
    private String id;
    @Field(name = "name")
    private String titile;
    @Field(name = "author")
    private String author;

    public Book() {
    }

    public Book(String id, String titile, String author) {
        this.id = id;
        this.titile = titile;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}