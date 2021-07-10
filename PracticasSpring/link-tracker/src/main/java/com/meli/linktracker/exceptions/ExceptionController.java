package com.meli.linktracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionController {

    @ExceptionHandler //
    @ResponseBody // Lo devuelto por el método se envia por body
    @ResponseStatus(value = HttpStatus.BAD_REQUEST) // Status enviado por header
    public ErrorMessage URLNotValid(MethodArgumentNotValidException exception){
        BindingResult result = exception.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        return new ErrorMessage(HttpStatus.BAD_REQUEST, "URL no válido", fieldErrors);
    }

}
