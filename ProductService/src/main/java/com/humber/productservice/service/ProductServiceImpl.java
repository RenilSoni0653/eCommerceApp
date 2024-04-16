package com.humber.productservice.service;

import com.humber.productservice.common.Constants;
import com.humber.productservice.entity.ProductDetail;
import com.humber.productservice.exception.ProductNotFoundException;
import com.humber.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public ProductDetail addNewProductDetail(ProductDetail productDetail) {
        log.info("ProductServiceImpl :: addNewProductDetail");
        return productRepository.save(productDetail);
    }

    public List<ProductDetail> getAllProducts() {
        log.info("ProductServiceImpl :: getAllProducts - START");
        List<ProductDetail> productDetail = productRepository.findAll();
        if(productDetail.isEmpty()) {
            throw new ProductNotFoundException(Constants.NO_PRODUCT_FOUND_MESSAGE);
        }
        log.info("ProductServiceImpl :: getAllProducts - END");
        return productDetail;
    }

    public Boolean deleteProduct(Long productId) {
        log.info("ProductServiceImpl :: deleteProduct - START");
        Optional<ProductDetail> productDetail = getProductById(productId);
        if (productDetail.isPresent()) {
            productDetail.get().setIsDeleted(true);
            productDetail.get().setIsAvailable(false);
            productRepository.save(productDetail.get());
        } else {
            throw new ProductNotFoundException(Constants.NO_PRODUCT_FOUND_MESSAGE);
        }
        log.info("ProductServiceImpl :: deleteProduct - END");
        return true;
    }

    public Optional<ProductDetail> getProductById(Long id) {
        log.info("ProductServiceImpl :: getProductById - START");
        Optional<ProductDetail> productDetail = productRepository.findById(id);
        if(productDetail.isEmpty()) {
            throw new ProductNotFoundException(Constants.NO_PRODUCT_FOUND_MESSAGE);
        }
        log.info("ProductServiceImpl :: getProductById - END");
        return productDetail;
    }
}
