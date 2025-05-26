package com.example.demo.external.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.external.gutrndexApiDto.BookDto;
import com.example.demo.external.gutrndexApiDto.BooksResponseDto;

import reactor.core.publisher.Mono;

@Component
public class GutendexApi {

    private final WebClient webClient;

    public GutendexApi(@Qualifier("gutendexClient") WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<List<BookDto>> getPopularBooksApi() {

        return webClient
                .get()
                .uri("books/?sort=popular")
                .retrieve()
                .bodyToMono(BooksResponseDto.class)
                .map(BooksResponseDto::books)
                .doOnError(err -> System.err.println("Error al llamar la API: " +
                        err.getMessage()));

    }

    public Mono<List<BookDto>> getBooksBy(String name) {

        return webClient
                .get()
                .uri("books/?search={name}", name)
                .retrieve()
                .bodyToMono(BooksResponseDto.class)
                .map(BooksResponseDto::books)
                .doOnError(err -> System.err.println("Error al llamar la API " +
                        err.getMessage()));
    }

}
