package com.meli.linktracker.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.util.List;

@Getter
@AllArgsConstructor
public class ErrorMessage {
    /*
    La finalidad de esta clase es informar con sus atributos cuál es la razón por la cual falló el programa
     */

    private HttpStatus status;
    private String message;
    private List<FieldError> fieldErrors;


}
