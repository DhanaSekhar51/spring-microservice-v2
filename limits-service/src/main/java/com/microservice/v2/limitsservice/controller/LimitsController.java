package com.microservice.v2.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.v2.limitsservice.bean.Limits;
import com.microservice.v2.limitsservice.configuration.Configuration;

@RestController
public class LimitsController {
	
	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public Limits retrieveLimits() {
		System.out.println("Controller..");
		return new Limits(configuration.getMinimum(), configuration.getMaximum());
//		return new Limits(1,1000);
	}
	
}
