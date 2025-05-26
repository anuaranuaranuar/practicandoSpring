package com.example.demo.external.gutrndexApiDto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BooksResponseDto(
      @JsonProperty("count") 
      String count,

      @JsonProperty("next") 
      String next,

      @JsonProperty("previous") 
      String previous,

      @JsonProperty("results") 
      List<BookDto> books

) {
}