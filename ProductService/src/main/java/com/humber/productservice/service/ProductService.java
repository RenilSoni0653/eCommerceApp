package com.humber.productservice.service;

import com.humber.productservice.entity.ProductDetail;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public ProductDetail addNewProductDetail(ProductDetail productDetail);
    public List<ProductDetail> getAllProducts();
    public Boolean deleteProduct(Long productId);
    public Optional<ProductDetail> getProductById(Long id);
}
