package com.example.demo.external.api;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Component
public class ExchangeApiClient {
    private final WebClient webClient;

    public ExchangeApiClient(
        @Qualifier("exchangeClient") WebClient webClient) {
        

        this.webClient = webClient;
    }

    public Mono<String> getExchangeRate(String base, String target, String mount) {
    return webClient.get()
            .uri("pair/{base}/{target}/{mount}", base, target, mount)
            .retrieve()
            .onStatus(status -> !status.is2xxSuccessful(),
                      response -> response.bodyToMono(String.class)
                               .flatMap(body -> Mono.error(new RuntimeException("API error: " + body))))
            .bodyToMono(String.class)
            .onErrorResume(e -> {
                System.err.println("Error calling external API: " + e.getMessage());
                return Mono.just("{\"error\":\"External API error\", \"message\":\"" + e.getMessage() + "\"}");
            });
}

}