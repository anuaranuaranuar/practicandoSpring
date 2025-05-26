package com.example.demo.external.gutrndexApiDto;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BookDto(
    @JsonProperty("id")
    String id,

    @JsonProperty("title")
    String title,

    @JsonProperty("authors") 
    List<AuthorDto> authors,

    @JsonProperty("summaries")
    List<String> summaries,
    
    @JsonProperty("subjects")
    List<String> personages,
    
    @JsonProperty("bookshelves")
    List<String> categories,

    @JsonProperty("languages")     
    List<String> languages,

    @JsonProperty("copyright")     
    String copyright,

    
    @JsonProperty("media_type")     
    String mediaType,

    @JsonProperty("formats")     
    Map<String,String> formats,

    @JsonProperty("download_count")
    String downloadCount
){}
