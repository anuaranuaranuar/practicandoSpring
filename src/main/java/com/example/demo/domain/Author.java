package com.example.demo.domain;

import java.time.Year;

public class Author {
      private String name;
      private Year birthYear;
      private Year deathYear;

      public Author(String name, Year birthYear, Year deathYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
      }

      public String getName() {
          return name;
      }

      public void setName(String name) {
          this.name = name;
      }

      public Year getBirthYear() {
          return birthYear;
      }

      public void setBirthYear(Year birthYear) {
          this.birthYear = birthYear;
      }

      public Year getDeathYear() {
          return deathYear;
      }

      public void setDeathYear(Year deathYear) {
          this.deathYear = deathYear;
      }

      
      
}
