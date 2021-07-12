package com.meli.linktracker.exceptions.custom;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class URLHttpStatusNot2xxException extends RuntimeException{

    String urlNotValid;
    HttpStatus httpStatus;

    public URLHttpStatusNot2xxException(String errorMessage, String urlNotValid, HttpStatus httpStatus) {
        super(errorMessage);
        this.urlNotValid = urlNotValid;
        this.httpStatus = httpStatus;
    }

}
