package com.thuannd.export;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

@Configuration
public class Config{

    @Bean(name = "viewResolver")
    public ResourceBundleViewResolver getViewResolver(){
        ResourceBundleViewResolver viewResolver = new ResourceBundleViewResolver();
        viewResolver.setOrder(1);
        viewResolver.setBasename("views");
        return viewResolver;
    }

}