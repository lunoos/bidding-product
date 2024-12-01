package com.bidding.product.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bidding.product.dto.S3UploadResp;
import com.bidding.product.service.S3Service;

@RestController
@RequestMapping("/api/s3")
public class S3Controller {

	@Autowired
    private S3Service s3Service;
	
	@Value("${aws.s3.expInMin}")
    private Long expirationInMinutes;
    
    @GetMapping("/upload-url")
    public ResponseEntity<S3UploadResp> getUploadUrl() {
    	String objectKey = UUID.randomUUID().toString();
        String presignedUrl = s3Service.generatePresignedUrlForUpload(objectKey, expirationInMinutes);
        return ResponseEntity.ok(new S3UploadResp(presignedUrl,objectKey));
    }
    
    @GetMapping("/download-url")
    public ResponseEntity<String> getDownloadUrl(
            @RequestParam String objectKey) {
        // Optional: Check if object exists before generating URL
        if (!s3Service.doesObjectExist(objectKey)) {
            return ResponseEntity.notFound().build();
        }
        String presignedUrl = s3Service.generatePresignedUrlForDownload(objectKey, expirationInMinutes);
        return ResponseEntity.ok(presignedUrl);
    }
}

