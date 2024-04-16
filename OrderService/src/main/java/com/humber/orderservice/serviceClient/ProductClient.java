package com.humber.orderservice.serviceClient;

import com.humber.orderservice.entity.ProductDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient("product-service")
public interface ProductClient {
    @GetMapping("/{productId}")
    public ResponseEntity<Optional<ProductDetail>> getProductById(@PathVariable Long productId);
}