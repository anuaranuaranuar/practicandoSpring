package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean("gutendexClient")
    public WebClient gutendexClient(GutendexApiConfig props, WebClient.Builder builder) {
        return builder.baseUrl(props.getBaseUrl()).build();
    }

    @Bean("exchangeClient")
    public WebClient exchangeClient(ExchangeApiProperties props, WebClient.Builder builder) {
        return builder.baseUrl(props.getBaseUrl() + props.getApikey()).build();
    }
}
