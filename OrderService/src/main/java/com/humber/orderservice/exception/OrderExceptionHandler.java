package com.humber.orderservice.exception;

import com.humber.orderservice.common.CustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrderExceptionHandler {
    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> productNotFoundException(OrderNotFoundException exc) {
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