package com.meli.linktracker.utils;

import com.meli.linktracker.exceptions.custom.URLNotValidException;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.io.IOException;

@Service
public class URLValidator implements IURLValidator {

    private final String[] SCHEMES = {"http", "https"};
    /*
    todo: NO HACE FALTA LLAMAR A ESTE SERVICIO, PUEDO MANJEAR LA VALIDACION CON UN HANDLER
     */
    @Override
    public void validate(String link) {
        UrlValidator urlValidator = new UrlValidator(SCHEMES);
        if (!urlValidator.isValid(link))
            throw new URLNotValidException("URL no válida", link);
    }
}
