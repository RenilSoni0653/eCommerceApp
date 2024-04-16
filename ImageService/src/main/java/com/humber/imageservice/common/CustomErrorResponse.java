package com.humber.imageservice.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomErrorResponse {
    private String message;
    private Long timestamp;
    private int status;
}
