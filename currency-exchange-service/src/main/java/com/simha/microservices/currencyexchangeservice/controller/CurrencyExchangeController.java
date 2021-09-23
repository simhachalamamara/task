package com.simha.microservices.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.simha.microservices.currencyexchangeservice.DAO.CurrencyExchangeRepository;
import com.simha.microservices.currencyexchangeservice.bean.CurrencyExchange;

@RestController

public class CurrencyExchangeController {

	@Autowired
	private Environment environment;
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retriveExchangeValue(@PathVariable String from, @PathVariable String to) {

		/*
		 * CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to,
		 * BigDecimal.valueOf(50));
		 * currencyExchange.setEnvirment(environment.getProperty("local.server.port"));
		 */

		CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
		currencyExchange.setEnvirment(environment.getProperty("local.server.port"));

		return currencyExchange;
	}

}
