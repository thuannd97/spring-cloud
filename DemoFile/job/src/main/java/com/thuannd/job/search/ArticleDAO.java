package com.thuannd.job.search;

import java.util.List;

import com.thuannd.job.Article;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDAO extends ElasticsearchRepository<Article, Long>{

    List<Article> findByTitle(String title);

}