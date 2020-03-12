package com.thuannd.job;

import org.springframework.batch.item.ItemProcessor;

public class ArticleItemProcessor implements ItemProcessor<Article, Article>{

    @Override
    public Article process(Article item) throws Exception {
        Article article = new Article();
        article.setId(item.getId());
        article.setTitle(item.getTitle());
        article.setContent(item.getContent());
        return article;
    }

    
}