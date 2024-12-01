package com.bidding.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bidding.product.entity.Product;
import com.bidding.product.exception.VendorNotFoundException;
import com.bidding.product.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ValidateService validateService;

	@Transactional
    public Product createProduct(Product product) {
		if(validateService.validateVendor(product))
        return productRepository.save(product);
		else
			throw new VendorNotFoundException("Vendor does not exist");
    }

    public Optional<Product> getProductById(String productId) {
        return productRepository.findById(productId);
    }

    public List<Product> getProductsByVendorId(Long vendorId) {
        return productRepository.findByVendorId(vendorId);
    }

    /**
     * Vendor cannot be updated in a product.
     */
    @Transactional
    public Product updateProduct(Product product) {
    	Optional<Product> extProdt = productRepository.findById(product.getProductId());
//    	if(extProdt.get().getVendorId()!=product.getProductId())
//    		throw new ProductUpdateException("A vendor cannot be updated for a existing product");
        return productRepository.save(product);
    }

    @Transactional
    public void deleteProduct(String productId) {
        productRepository.deleteById(productId);
    }


}