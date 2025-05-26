package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Book;
import com.example.demo.external.api.GutendexApi;
import com.example.demo.mapper.BookMapper;

import reactor.core.publisher.Mono;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/")
public class BooksController {
    private final GutendexApi apiClient;

    public BooksController(GutendexApi apiClient) {
        this.apiClient = apiClient;
    }

    @GetMapping("books")
    public Mono<List<Book>> getPopularBooks() {

        return apiClient.getPopularBooksApi()
                .map(BookMapper::mapBooks)
                .map(books -> books.stream() // mapeamos para ordenar los libros por n° descargas
                        .sorted((book1, book2) -> book2.getDownloadCount()
                                .subtract(book1.getDownloadCount())
                                .intValue())
                        .toList());

    }

    @GetMapping("/search/{name}")
    public Mono<List<Book>> getSearchBook(@PathVariable String name) {
        return apiClient.getBooksBy(name)
                .map(BookMapper::mapBooks)
                .doOnNext(books -> System.out.println(
                        books.stream()
                                .mapToInt(book -> book.getDownloadCount()
                                        .intValue())
                                .summaryStatistics()));

    }

}
