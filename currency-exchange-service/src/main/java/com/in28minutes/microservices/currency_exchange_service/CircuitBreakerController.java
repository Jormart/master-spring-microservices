package com.in28minutes.microservices.currency_exchange_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
    // This class can be used to implement circuit breaker logic
    // For example, using Resilience4j or Spring Cloud Circuit Breaker
    // Currently, it is empty and serves as a placeholder for future implementation

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
    // @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
    // @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
    // @RateLimiter
    @Bulkhead(name = "sample-api")
    // 10s => 10000 calls to the sample API
    public String sampleApi() {
        logger.info("Sample API call received");
        // HttpEntity<String> forEntity = new RestTemplate().getForEntity(
        // "http://localhost:8080/some-external-api", String.class);
        // // This method can be used to demonstrate circuit breaker functionality
        // return forEntity.getBody();
        return "Sample API response";
    }

    public String hardcodedResponse(Exception ex) {
        // This method is called when the circuit breaker is open or when an exception
        // occurs
        logger.info("Fallback method called due to: {}", ex.getMessage());
        return "Fallback response";
    }
}
