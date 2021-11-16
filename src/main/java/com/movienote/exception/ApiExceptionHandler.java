package com.movienote.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    //handle specific exception
    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {

        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        ApiExceptionErrorDetails apiExceptionErrorDetails = new ApiExceptionErrorDetails(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiExceptionErrorDetails, badRequest);
    }

    //handle specific exception
    @ExceptionHandler(value = {MovienoteServiceException.class})
    public ResponseEntity<Object> handleMovienoteServiceException(MovienoteServiceException e) {

        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        ApiExceptionErrorDetails apiExceptionErrorDetails = new ApiExceptionErrorDetails(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiExceptionErrorDetails, badRequest);
    }

    //handle global exception
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleGlobalApiRequestException(Exception e) {

        HttpStatus internalServerError = HttpStatus.INTERNAL_SERVER_ERROR;

        ApiExceptionErrorDetails apiExceptionErrorDetails = new ApiExceptionErrorDetails(
                e.getMessage(),
                internalServerError,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiExceptionErrorDetails, internalServerError);
    }
}
