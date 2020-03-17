package com.thuannd.export;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ArticleRepository extends JpaRepository<Article, Long>{

    List<Article> findAll();

}