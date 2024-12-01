package com.bidding.product.exception;

public class VendorNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public VendorNotFoundException(String errorMssg) {
		super(errorMssg);
	}

}
