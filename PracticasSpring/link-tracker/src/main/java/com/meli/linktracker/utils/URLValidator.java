package com.meli.linktracker.utils;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Service;

@Service
public class URLValidator implements IURLValidator {

    private final String[] SCHEMES = {"http", "https"};
    /*
    todo: NO HACE FALTA LLAMAR A ESTE SERVICIO, PUEDO MANJEAR LA VALIDACION CON UN HANDLER
     */
    @Override
    public void validate(String link) throws Exception {
        UrlValidator urlValidator = new UrlValidator(SCHEMES);
        /*
        if (!urlValidator.isValid(link)) {
            throw new Exception("Oops!");//URLNotValidException(, );
        }
         */

    }
}
