package com.movienote.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
@Slf4j
public class ApiExceptionHandler {


    //handle specific exception
    @ExceptionHandler(value = {RequestException.class})
    public ResponseEntity<Object> handleApiRequestException(RequestException e) {

        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        ErrorDetails errorDetails = new ErrorDetails(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        log.error("Caught RequestException: - {}",e.getMessage());

        return new ResponseEntity<>(errorDetails, badRequest);
    }

    //handle specific exception
    @ExceptionHandler(value = {MovienoteServiceException.class})
    public ResponseEntity<Object> handleMovienoteServiceException(MovienoteServiceException e) {

        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        ErrorDetails errorDetails = new ErrorDetails(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        log.error("Caught MovienoteServiceException exception: - {}",e.getMessage());

        return new ResponseEntity<>(errorDetails, badRequest);
    }

    //handle global exception
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleGlobalApiRequestException(Exception e) {

        HttpStatus internalServerError = HttpStatus.INTERNAL_SERVER_ERROR;

        ErrorDetails errorDetails = new ErrorDetails(
                e.getMessage(),
                internalServerError,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        log.error("Exception: - {} ",e.getMessage());

        return new ResponseEntity<>(errorDetails, internalServerError);
    }
}

