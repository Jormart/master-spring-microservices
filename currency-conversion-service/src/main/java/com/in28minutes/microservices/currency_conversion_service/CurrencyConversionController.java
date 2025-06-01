package com.in28minutes.microservices.currency_conversion_service;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeProxy proxy;

    // Define endpoints and methods for currency conversion here
    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertCurrency(@PathVariable String from,
            @PathVariable String to, @PathVariable BigDecimal quantity) {

        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyConversion.class, uriVariables);

        CurrencyConversion currencyConversion = responseEntity.getBody();
        if (currencyConversion == null) {
            throw new RuntimeException("Unable to find data for " + from + " to " + to);
        }

        return new CurrencyConversion(
                currencyConversion.getId(),
                from,
                to,
                quantity,
                currencyConversion.getConversionMultiple(),
                quantity.multiply(currencyConversion.getConversionMultiple()),
                currencyConversion.getEnvironment());

        // Hardcoded values for demonstration purposes
        // return new CurrencyConversion(10001L, from, to, quantity,
        // BigDecimal.ONE, BigDecimal.ONE, "test-environment");
    }

    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertCurrencyFeign(@PathVariable String from,
            @PathVariable String to, @PathVariable BigDecimal quantity) {

        // Using Feign client to call the currency exchange service
        // This assumes that the CurrencyExchangeProxy is correctly set up
        CurrencyConversion currencyConversion = proxy.retrieveExchangeValue(from, to);

        if (currencyConversion == null) {
            throw new RuntimeException("Unable to find data for " + from + " to " + to);
        }

        return new CurrencyConversion(
                currencyConversion.getId(),
                from,
                to,
                quantity,
                currencyConversion.getConversionMultiple(),
                quantity.multiply(currencyConversion.getConversionMultiple()),
                currencyConversion.getEnvironment() + " using Feign client");
    }
}
