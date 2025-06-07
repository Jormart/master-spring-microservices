package com.in28minutes.microservices.currency_exchange_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class.getName());

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

        /*
         * INFO [currency-exchange,96111ca54994fd662efb102b27b1f711,d5b3ce9d43f8de66]
         * 4584 --- [currency-exchange] [nio-8000-exec-1]
         * [96111ca54994fd662efb102b27b1f711-d5b3ce9d43f8de66]
         * c.i.m.c.CurrencyExchangeController : retrieveExchangeValue called with from:
         * USD, to: INR
         */
        logger.info("retrieveExchangeValue called with from: {}, to: {}", from, to);

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