package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.external.api.ExchangeApiClient;

import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("pair")
public class CurrencyController {

    private final ExchangeApiClient apiClient;

    public CurrencyController(ExchangeApiClient apiClient) {
        this.apiClient = apiClient;
    }

    
    @GetMapping("{base}/{target}/{mount}")
    public Mono<String> getConvertCurrency(
            @PathVariable String base,
            @PathVariable String target,
            @PathVariable String mount) {
                
        System.out.println("Request received: " + base + " to " + target + ", amount: " + mount);

        return apiClient.getExchangeRate(base, target, mount);
    }

}