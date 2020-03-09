package com.thuannd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class HystrixExampleController {

	@GetMapping("/call-hello")
	@HystrixCommand(fallbackMethod = "defaultResponse")
	public String callHello() {
		return new RestTemplate().getForObject("http://aht-client04.vpngitlab.com:8086/hello", String.class);
	}
	
	public String defaultResponse() {
		return "thong tin mac dinh tra ve";
	}
	
}
