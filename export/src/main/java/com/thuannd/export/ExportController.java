package com.thuannd.export;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/export-service")
public class ExportController{

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/artciles")
    public List<Article> getAllArtcile(){
        return articleRepository.findAll();
    }

}