package com.in28minutes.microservices.currency_exchange_service;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    // Define endpoints and methods to handle currency exchange requests here
    // For example, you might have a method to get the exchange rate between two
    // currencies
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from,
            @PathVariable String to) {
        return new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(50));
    }

    // Additional methods can be added as needed for the service functionality
}
