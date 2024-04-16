package com.humber.imageservice.exception;

public class ImageNotFoundException extends RuntimeException {
    public ImageNotFoundException() {
    }

    public ImageNotFoundException(String message) {
        super(message);
    }
}
