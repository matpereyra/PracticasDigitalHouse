package com.meli.linktracker.services;

import com.meli.linktracker.exceptions.custom.URLHttpStatusNot2xxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;


@Service
public class HttpRequestor {

    private RestTemplate restTemplate;

    @Autowired
    public HttpRequestor(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    public HttpStatus requestStatus(String link) {
        ResponseEntity<String> response = null;
        try {
            response = this.restTemplate.getForEntity(link, String.class);
        } catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
            if (HttpStatus.NOT_FOUND.equals(httpClientOrServerExc.getStatusCode()))
                return HttpStatus.NOT_FOUND;
            /* todo: NUNCA DEVUELVE EL VALOR NOT_FOUND PORQUE SALTA DIRECTAMENTE A LA EXCEPCION  */
        }
        return response.getStatusCode();
    }
}
