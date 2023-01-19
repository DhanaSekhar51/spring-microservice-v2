package com.microservice.v2.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayonfiguration {

	/**
	 * Below method written for applying custom filters
	 * @param builder
	 * @return
	 */
	
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/get")
						.filters(f -> f.addRequestHeader("MyHeader", "MyURI")
								.addRequestParameter("Param", "MyValue"))
						.uri("http://httpbin.org:80"))	
				.route(p->p.path("/currency-exchange/**")
						.uri("lb://currency-exchange")	//It will talk to eureka and check given server apply loadbalancing(lb)
						)
				.route(p->p.path("/currency-conversion-feign/**")
						.uri("lb://currency-conversion"))
				.route(p->p.path("/currency-conversion-new/**")
						.filters(f->f.rewritePath(
								"/currency-conversion-new/(?<segment>.*)", 
								"/currency-conversion-feign/${segment}"))
						.uri("lb://currency-conversion"))
				.build();
	}
	
}
