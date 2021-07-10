package com.meli.linktracker.exceptions.custom;

import com.meli.linktracker.exceptions.ErrorMessage;
import lombok.Getter;

@Getter
public class URLNotValidException extends RuntimeException{

    String urlNotValid;

    /*
    public URLNotValidException(String errorMessage, Throwable originalException) {
        super(errorMessage, originalException);
    }
     */

    public URLNotValidException(String errorMessage, String urlNotValid) {
        super(errorMessage);
        this.urlNotValid = urlNotValid;
    }
}
