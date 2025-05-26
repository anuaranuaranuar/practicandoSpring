package com.example.demo.external.api;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.external.gutrndexApiDto.BooksResponseDto;

import reactor.core.publisher.Mono;

@Component
public class GutendexApi {

    private final WebClient webClient;

    public GutendexApi(WebClient.Builder webClient) {
        this.webClient = webClient
                .baseUrl("https://gutendex.com/")
                .build();

    }

    public Mono<BooksResponseDto> getBooks() {

        return webClient
                .get()
                .uri("books/?sort=popular")
                .retrieve()
                .bodyToMono(BooksResponseDto.class)
                .doOnNext(response -> System.out.println("Contenido recibido:\n" + response))
                .doOnError(error -> System.err.println("Error al llamar la API: " + error.getMessage()));
        
    }

}
