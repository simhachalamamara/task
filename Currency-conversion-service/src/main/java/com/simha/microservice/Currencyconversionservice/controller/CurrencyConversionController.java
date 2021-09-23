package com.simha.microservice.Currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.simha.microservice.Currencyconversionservice.bean.CurrencyConversion;
import com.simha.microservice.Currencyconversionservice.bean.OpenFeignClientExchnage;

@RestController
public class CurrencyConversionController {

	@Autowired
	private Environment envirment;
	@Autowired
	private OpenFeignClientExchnage openFeignClientExchnage;

	@GetMapping("currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion getCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		String port = envirment.getProperty("server.port");
		/*
		 * CurrencyConversion currencyConversion = new CurrencyConversion(1000l, from,
		 * to, quantity, 1, 65, port);
		 */

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversion> responEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);

		CurrencyConversion currencyConversion = responEntity.getBody();
		currencyConversion.setQuantity(quantity);
		currencyConversion.setTotalCalculatedAmount(quantity.multiply(currencyConversion.getConversionMultiple()));
		return currencyConversion;

	}

	@GetMapping("/currency-conversionfeign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion getCurrencyConversionfeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		String port = envirment.getProperty("server.port");
		/*
		 * CurrencyConversion currencyConversion = new CurrencyConversion(1000l, from,
		 * to, quantity, 1, 65, port);
		 */
		CurrencyConversion currencyConversion = openFeignClientExchnage.retriveExchangeValue(from,to);

		currencyConversion.setQuantity(quantity);
		currencyConversion.setTotalCalculatedAmount(quantity.multiply(currencyConversion.getConversionMultiple()));
		return currencyConversion;

	}

}
