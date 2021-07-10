package com.meli.linktracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpRequestor {

    private RestTemplate restTemplate;

    @Autowired
    public HttpRequestor(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    public String request(String link) {
        String json = this.restTemplate.getForObject(link, String.class);
        return json;
    }
}
