package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Book;
import com.example.demo.external.api.GutendexApi;
import com.example.demo.external.gutrndexApiDto.BooksResponseDto;
import com.example.demo.mapper.BookMapper;

import reactor.core.publisher.Mono;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/")
public class BooksController {
    private final GutendexApi apiClient;

    public BooksController(GutendexApi apiClient) {
        this.apiClient = apiClient;
    }

    @GetMapping("books")
    public Mono<List<Book>> getResponseBooks() {

        return apiClient.getBooks()
                .map(res -> res.books()
                        .stream()
                        .map(BookMapper::mapBook)
                        .sorted((book1, book2) -> book2.getDownloadCount()
                                .subtract(book1.getDownloadCount())
                                .intValue())
                        .toList());

    }

}
