package com.bidding.product.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bidding.product.entity.Product;
import com.bidding.product.restCallHandler.VendorClient;

@Service
public class ValidateServiceImpl implements ValidateService{
	
	@Autowired
	private VendorClient vendorClient;

	@Override
	public boolean validateVendor(Product product) {
		// TODO Auto-generated method stub
		Object obj = vendorClient.getVendorById(product.getVendorId()).getBody();
		return Objects.isNull(obj)?false:true;
	}

}
