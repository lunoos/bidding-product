package com.bidding.product.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bidding.product.entity.Product;


public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByVendorId(Long vendorId);
}