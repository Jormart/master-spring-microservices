package com.in28minutes.microservices.currency_exchange_service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository
        extends JpaRepository<CurrencyExchange, Long> {
    // Method to find exchange rate by currency pair
    CurrencyExchange findByFromAndTo(String from, String to);
}