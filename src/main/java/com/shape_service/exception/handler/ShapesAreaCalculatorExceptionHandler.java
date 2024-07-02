package com.shape_service.exception.handler;


import com.shape_service.exception.UnsupportedCalculationTypeException;
import com.shape_service.exception.UnsupportedShapeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class ShapesAreaCalculatorExceptionHandler {

    @ExceptionHandler (UnsupportedShapeException.class)
    public ResponseEntity<Object> handleUnsupportedShape (UnsupportedShapeException exception) {
        log.error ("Unsupported shape: {}", exception.getMessage ());
        return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler (UnsupportedCalculationTypeException.class)
    public ResponseEntity<Object> handleUnsupportedCalculationType (UnsupportedCalculationTypeException exception) {
        log.error ("Unsupported shape: {}", exception.getMessage ());
        return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions (MethodArgumentNotValidException ex) {
        log.info ("Method argument not valid for http requests, message: {}", ex.getMessage ());
        String errorMessage = ex.getBindingResult ()
                .getFieldErrors ()
                .stream ()
                .map (error -> error.getField () + ": " + error.getDefaultMessage ())
                .collect (Collectors.joining (", "));
        return new ResponseEntity<> (errorMessage, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler (MissingServletRequestParameterException.class)
    public ResponseEntity<Object> handleInternal (MissingServletRequestParameterException exception) {
        log.error ("Unsupported shape: {}", exception.getMessage ());
        return new ResponseEntity<> (exception.getMessage (), HttpStatus.EXPECTATION_FAILED);
    }

}
