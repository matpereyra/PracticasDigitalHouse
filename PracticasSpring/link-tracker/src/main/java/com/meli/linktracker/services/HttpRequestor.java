package com.meli.linktracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class HttpRequestor {

    private RestTemplate restTemplate;

    @Autowired
    public HttpRequestor(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    /*
    Probando metodos de RestTemplate.
     */
    public HttpStatus requestStatus(String link) {
        // Recibo HTML (para probar)
        //String json = this.restTemplate.getForObject(link, String.class);
        // Lo recibo como un ResponseEntity. El HTML es enviado por body ¿?
        ResponseEntity<String> response = this.restTemplate.getForEntity(link, String.class);
        return response.getStatusCode();
    }
}
