package com.example.demo.mapper;

import java.math.BigInteger;
import java.net.URI;
import java.time.Year;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import com.example.demo.external.gutrndexApiDto.AuthorDto;
import com.example.demo.external.gutrndexApiDto.BookDto;

public class BookMapper {
    public static Book mapBook(BookDto dto) {
        return new Book(
                dto.title(),
                mapAuthor(dto.authors()),
                dto.summaries(),
                dto.personages(),
                dto.categories(),
                mapUrl(dto.formats()),
                mapBigInteger(dto.downloadCount()));
    }

    public static List<Author> mapAuthor(List<AuthorDto> list) {
        return list.stream()
                .map(author -> new Author(
                        author.name(),
                        mapYear(author.birth_year()),
                        mapYear(author.death_year())))
                .toList();

    }

    public static Year mapYear(String year) {

        try {
            return Year.of(Integer.parseInt(year));
        } catch (NumberFormatException e) {
            System.out.println("No se pudo convertir la fecha: " +
                    e.getMessage());
            return null;
        }
    }

    public static Map<String, URI> mapUrl(Map<String, String> formats) {
        Map<String, URI> newMap = new HashMap<>();

        for (Map.Entry<String, String> format : formats.entrySet()) {
            try {
                newMap.put(
                        format.getKey(),
                        URI.create(format.getValue()));
            } catch (IllegalArgumentException e) {
                System.out.println("No se pudo crear la URL " +
                        e.getMessage());
            }
        }
        return newMap;
    }

    public static BigInteger mapBigInteger(String value) {
        try {
            return new BigInteger(value);
        } catch (NumberFormatException e) {
            System.out.println("No se pudo convertir el valor " +
                    e.getMessage());
            return BigInteger.ZERO;
        }

    }
}
