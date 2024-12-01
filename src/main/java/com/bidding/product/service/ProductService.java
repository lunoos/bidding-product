package com.bidding.product.service;

import java.util.List;
import java.util.Optional;

import com.bidding.product.entity.Product;

public interface ProductService {

	public Product createProduct(Product product);

    public Optional<Product> getProductById(String productId);

    public List<Product> getProductsByVendorId(Long vendorId);

    public Product updateProduct(Product product);

    public void deleteProduct(String productId);
}
