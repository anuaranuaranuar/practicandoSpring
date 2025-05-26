package com.example.demo.external.gutrndexApiDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthorDto(
     @JsonProperty("name") 
      String name,

      @JsonProperty("birth_year") 
      String birth_year,

      @JsonProperty("death_year") 
      String death_year
) {
} 
