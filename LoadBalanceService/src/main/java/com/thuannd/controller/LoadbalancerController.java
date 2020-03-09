package com.thuannd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoadbalancerController {

	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@GetMapping("/load-balance")
	public String getServiceInstanceInfor() {
		return loadBalancerClient.choose("Eureka Client Example").getUri().toString();
	}
	
}
