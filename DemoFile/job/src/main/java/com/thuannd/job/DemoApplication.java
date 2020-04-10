package com.thuannd.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.thuannd.job.search")
@EnableJpaRepositories(basePackages = "com.thuannd.job")
public class DemoApplication{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
   	public RestTemplate getRestTemplate() {
      return new RestTemplate();
	}
	
}
