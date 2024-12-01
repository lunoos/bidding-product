package com.bidding.product.exception;

public class ProductUpdateException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductUpdateException(String errorMssg) {
		super(errorMssg);
	}
}
