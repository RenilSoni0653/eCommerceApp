package com.humber.imageservice.exception;

public class UnableToSaveImageException extends RuntimeException {
    public UnableToSaveImageException() {
    }

    public UnableToSaveImageException(String message) {
        super(message);
    }
}
