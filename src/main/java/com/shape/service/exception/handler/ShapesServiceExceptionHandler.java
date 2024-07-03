package com.shape.service.exception.handler;

import com.shape.service.exception.NegativeShapeParameterException;
import com.shape.service.exception.UnsupportedCalculationTypeException;
import com.shape.service.exception.UnsupportedShapeException;
import com.shape.service.exception.MissingShapeParametersException;
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
public class ShapesServiceExceptionHandler {

    @ExceptionHandler (UnsupportedShapeException.class)
    public ResponseEntity<Object> handleUnsupportedShape (UnsupportedShapeException exception) {
        log.error ("Unsupported shape: {}", exception.getMessage ());
        return new ResponseEntity<> (String.format ("Unsupported shape: %s", exception.getMessage ()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler (UnsupportedCalculationTypeException.class)
    public ResponseEntity<Object> handleUnsupportedCalculation (UnsupportedCalculationTypeException exception) {
        log.error ("Unsupported calculation type: {}", exception.getMessage ());
        return new ResponseEntity<> (String.format ("Unsupported calculation type: %s", exception.getMessage ()), HttpStatus.BAD_REQUEST);
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
    public ResponseEntity<Object> handleMissingRequestParams (MissingServletRequestParameterException exception) {
        log.error ("Missing request params: {}", exception.getMessage ());
        return new ResponseEntity<> (exception.getMessage (), HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler (MissingShapeParametersException.class)
    public ResponseEntity<Object> handleMissingShapeParams (MissingShapeParametersException exception) {
        log.error ("Missing shape params/fields: {}", exception.getMessage ());
        return new ResponseEntity<> (exception.getMessage (), HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler (NegativeShapeParameterException.class)
    public ResponseEntity<Object> handleNegativeShapeParams (NegativeShapeParameterException exception) {
        log.error ("Negative request params: {}", exception.getMessage ());
        return new ResponseEntity<> (exception.getMessage (), HttpStatus.EXPECTATION_FAILED);
    }

}
