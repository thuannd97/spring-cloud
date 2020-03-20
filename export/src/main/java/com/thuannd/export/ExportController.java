package com.thuannd.export;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/export-service")
public class ExportController{

    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping(value = "/artciles", method = RequestMethod.GET)
    public ModelAndView getAllArtcile(){
        ModelAndView mv = new ModelAndView("pdfView");
        mv.getModelMap().put("data", articleRepository.findAll());
        return mv;
    }

}