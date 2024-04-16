package com.humber.productservice.exception;

import com.humber.productservice.common.CustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> productNotFoundException(ProductNotFoundException exc) {
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