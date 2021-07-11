package com.meli.linktracker.utils;

import com.meli.linktracker.DTOs.response.LinkResponseDTO;
import com.meli.linktracker.exceptions.custom.URLHttpStatusNot2xxException;
import com.meli.linktracker.exceptions.custom.URLNotValidException;
import com.meli.linktracker.services.HttpRequestor;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.io.IOException;

@Service
public class URLValidator implements IURLValidator {

    private final String[] SCHEMES = {"http", "https"};
    /*
    HttpRequestor httpRequestor;

    @Autowired
    public URLValidator(HttpRequestor httpRequestor) {
        this.httpRequestor = httpRequestor;
    }
    */
    /*
        todo: NO HACE FALTA LLAMAR A ESTE SERVICIO, PUEDO MANJEAR LA VALIDACION CON UN HANDLER
         */
    @Override
    public void validate(String link) {
        UrlValidator urlValidator = new UrlValidator(SCHEMES);
        if (!urlValidator.isValid(link)) {
            throw new URLNotValidException("URL no válida", link);
        }
        /*
        HttpStatus status = httpRequestor.requestStatus(link);
        if (!status.is2xxSuccessful()) {
            throw new URLHttpStatusNot2xxException("El request a esa URL no devuelve un estado válido", link, status);
        }
        */
    }
}
