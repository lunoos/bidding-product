package com.bidding.product.restCallHandler;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="Vendor",url = "http://localhost:8082/vendors/")
public interface VendorClient {

	@GetMapping("/vendor/{vendorId}")
	ResponseEntity<Object> getVendorById(@PathVariable Long vendorId);
	
}
