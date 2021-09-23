package com.simha.microservices.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBrakerReselience {

	private Logger logger=LoggerFactory.getLogger(CircuitBrakerReselience.class);
	@GetMapping("/sample-dummy")
	@Retry(name = "simpleDemo", fallbackMethod = "dummy")

	public String getsample() {
		logger.info("yes here hitting time are: ");
		ResponseEntity<String> entity = new RestTemplate().getForEntity("http://localhost:8080/sample-dummyies",
				String.class);

		return entity.getBody();
	}

	public String dummy(Exception ex)

	{
		return "we are returning dummy response to them";
	}

}
