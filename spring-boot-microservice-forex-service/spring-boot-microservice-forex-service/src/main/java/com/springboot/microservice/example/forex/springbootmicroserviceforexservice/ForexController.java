package com.springboot.microservice.example.forex.springbootmicroserviceforexservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForexController {

	@Autowired
	private Environment environment;

	@Autowired
	private ExchangeValueRepository repo;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue getExchangeValue(@PathVariable String from, @PathVariable String to) {

		ExchangeValue exchangeValue = repo.findByFromAndTo(from, to);

		exchangeValue.setPort(Integer.parseInt(environment.getProperty("server.port")));

		return exchangeValue;

	}
}
