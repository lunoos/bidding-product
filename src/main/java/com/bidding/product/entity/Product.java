package com.bidding.product.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



@Document(collection = "products")
public class Product {
	
    @Id
    private String productId;

    @Field(name = "vendor_id")
    private Long vendorId;

    @Field(name = "product_name")
    private String productName;

    @Field(name = "product_description")
    private String productDescription;

    @Field(name = "category_code")
    private String categoryCode;

    @Field(name = "category_name")
    private String categoryName;

    @Field(name = "product_Key")
    private String productKey;

    @Field(name = "base_price")
    private BigDecimal basePrice;

    @CreatedDate
    @Field(name = "created_at")
    private LocalDateTime createdAt;

    @Field(name = "updated_at")
    private LocalDateTime updatedAt;

    // Getters and setters

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getProductKey() {
		return productKey;
	}

	public void setProductKey(String productKey) {
		this.productKey = productKey;
	}

	public BigDecimal getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", vendorId=" + vendorId + ", productName=" + productName
				+ ", productDescription=" + productDescription + ", categoryCode=" + categoryCode + ", categoryName="
				+ categoryName + ", productKey=" + productKey + ", basePrice=" + basePrice + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
