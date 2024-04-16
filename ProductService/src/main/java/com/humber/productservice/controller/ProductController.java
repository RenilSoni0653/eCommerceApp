package com.humber.productservice.controller;

import com.humber.productservice.entity.ProductDetail;
import com.humber.productservice.serviceClient.ImageClient;
import com.humber.productservice.service.ProductServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
@Slf4j
public class ProductController {

    private final ProductServiceImpl productServiceImpl;

    private final ImageClient imageClient;

    @PostMapping("/create/{id}")
    public ResponseEntity<ProductDetail> addNewProductDetail(@PathVariable("id") Long imageId,
                                                             @RequestBody ProductDetail productDetail) {
        log.info("Product Controller :: addNewProductDetail - START");
        productDetail.setImageId(imageClient.getImageInfoById(imageId).getBody());
        log.info("Product Controller :: addNewProductDetail - END");
        return ResponseEntity.ok(productServiceImpl.addNewProductDetail(productDetail));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProductDetail>> getAllProductDetails() {
        log.info("Product Controller :: getAllProductDetails");
        return ResponseEntity.ok(productServiceImpl.getAllProducts());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Optional<ProductDetail>> getProductById(@PathVariable Long productId) {
        log.info("Product Controller :: getProductById");
        return ResponseEntity.ok(productServiceImpl.getProductById(productId));
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {
        log.info("Product Controller :: deleteProduct - START");
        productServiceImpl.deleteProduct(productId);
        log.info("Product Controller :: deleteProduct - END");
        return ResponseEntity.ok("Product deleted successfully.");
    }
}
