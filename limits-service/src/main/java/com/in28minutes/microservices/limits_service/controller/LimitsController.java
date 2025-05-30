package com.in28minutes.microservices.limits_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.limits_service.bean.Limits;
import com.in28minutes.microservices.limits_service.configuration.Configuration;

@RestController
public class LimitsController {

    @Autowired
    private Configuration configuration;

    // Define endpoints here to handle requests related to limits
    // For example, you might have an endpoint to get the current limits
    // or to update the limits based on some configuration.

    @GetMapping("/limits")
    public Limits getLimits() {
        return new Limits(configuration.getMinimum(), configuration.getMaximum());
        // return new Limits(1, 1000); // Example limits
    }
}
