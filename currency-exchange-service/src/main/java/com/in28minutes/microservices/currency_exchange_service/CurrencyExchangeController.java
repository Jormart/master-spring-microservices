package com.in28minutes.microservices.currency_exchange_service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeRepository repository;

    @Autowired
    private Environment environment;

    // Define endpoints and methods to handle currency exchange requests here
    // For example, you might have a method to get the exchange rate between two
    // currencies
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from,
            @PathVariable String to) {
        // CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to,
        // BigDecimal.valueOf(50));

        // Fetch the exchange rate from the repository
        CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
        if (currencyExchange == null) {
            throw new RuntimeException("Unable to find data for " + from + " to " + to);
        }

        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);

        return currencyExchange;
    }

    // Additional methods can be added as needed for the service functionality
}
