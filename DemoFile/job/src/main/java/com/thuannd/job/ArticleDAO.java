package com.thuannd.job;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class ArticleDAO{

    @PersistenceContext
    private EntityManager entityManager;

    public void add(Article article){
        entityManager.persist(article);
    }

    public void addBatch(List<Article> articles){
        articles.forEach(article ->{
            add(article);
        });
    }

}