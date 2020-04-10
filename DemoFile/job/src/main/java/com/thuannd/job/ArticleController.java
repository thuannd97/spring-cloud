package com.thuannd.job;

import java.util.ArrayList;
import java.util.List;

import com.thuannd.job.search.ArticleDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController{

    @Autowired
    private ArticleDAO articleDAO;

    @GetMapping("/search")
    public List<Article> findByTitle(@RequestParam(name = "q", required = true) String title){
        return articleDAO.findByTitle(title) != null ? articleDAO.findByTitle(title) : new ArrayList<>();
    }

}