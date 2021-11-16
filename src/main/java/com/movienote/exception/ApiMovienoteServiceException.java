package com.movienote.exception;

public class ApiMovienoteServiceException extends RuntimeException{

    public ApiMovienoteServiceException() {
    }

    public ApiMovienoteServiceException(String message) {
        super(message);
    }

    public ApiMovienoteServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
