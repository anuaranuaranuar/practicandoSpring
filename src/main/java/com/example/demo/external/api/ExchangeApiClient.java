package com.example.demo.external.api;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Component
public class ExchangeApiClient {
    private final WebClient webClient;

    public ExchangeApiClient(WebClient.Builder webClientBuilder) {
        

        this.webClient = webClientBuilder
                .baseUrl("https://v6.exchangerate-api.com/v6/aafd4024a38845e16e3a0cd5/")
                .build();
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