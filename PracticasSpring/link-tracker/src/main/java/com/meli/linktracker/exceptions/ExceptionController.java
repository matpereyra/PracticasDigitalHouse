package com.meli.linktracker.exceptions;

import com.meli.linktracker.exceptions.custom.URLHttpStatusNot2xxException;
import com.meli.linktracker.exceptions.custom.URLNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ErrorMessage> URLNotValid(URLNotValidException e){
        ErrorMessage msg = new ErrorMessage(HttpStatus.BAD_REQUEST, e.getMessage() + ": " + e.getUrlNotValid());
        return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler //
    @ResponseBody // Lo devuelto por el método se envia por body
    @ResponseStatus(value = HttpStatus.BAD_REQUEST) // Status enviado por header
    public ResponseEntity<ErrorMessage> URLHttpStatusNot2xx(URLHttpStatusNot2xxException e){
        //ErrorMessage msg = new ErrorMessage(e.getHttpStatus(), e.getMessage() + ": " + e.getUrlNotValid());
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

}
