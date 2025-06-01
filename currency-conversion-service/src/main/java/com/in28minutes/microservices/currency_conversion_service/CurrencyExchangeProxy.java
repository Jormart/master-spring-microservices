package com.in28minutes.microservices.currency_conversion_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange", url = "http://localhost:8000")
public interface CurrencyExchangeProxy {
    // Define methods to call the currency exchange service
    // For example:
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyConversion retrieveExchangeValue(
            @PathVariable("from") String from,
            @PathVariable("to") String to);
}