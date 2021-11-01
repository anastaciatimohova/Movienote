package com.movienote.exception;

public class MovienoteServiceException extends RuntimeException{
    public MovienoteServiceException() {
    }

    public MovienoteServiceException(String message) {
        super(message);
    }

    public MovienoteServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
