package com.humber.imageservice.exception;

import com.humber.imageservice.common.CustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ImageNotFoundExceptionHandler {
    @ExceptionHandler(ImageNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> imageNotFoundExceptionHandler(ImageNotFoundException exc) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(
                        CustomErrorResponse
                                .builder()
                                .message(exc.getMessage())
                                .timestamp(System.currentTimeMillis())
                                .status(HttpStatus.NOT_FOUND.value())
                                .build()
                );
    }
}
