package com.humber.productservice.repository;

import com.humber.productservice.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductDetail, Long> {
    Optional<ProductDetail> findByName(String name);
}
