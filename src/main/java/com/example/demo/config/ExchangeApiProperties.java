package com.example.demo.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="exchange")
public class ExchangeApiProperties {
  
    private String baseUrl;

    
    private String apikey;


    public String getBaseUrl() {
        return baseUrl;
    }


    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }


    public String getApikey() {
        return apikey;
    }


    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

   
}
