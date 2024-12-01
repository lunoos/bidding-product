package com.bidding.product.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.HeadObjectRequest;
import software.amazon.awssdk.services.s3.model.NoSuchKeyException;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedGetObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedPutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest;

@Service
public class S3Service {

	@Autowired
    private S3Presigner s3Presigner;
	
	@Autowired
    private S3Client s3Client;
    
    @Value("${aws.s3.bucket.name}")
    private String bucketName;
    
    public String generatePresignedUrlForUpload(String objectKey, long expirationInMinutes) {
        try {
            PutObjectPresignRequest presignRequest = PutObjectPresignRequest.builder()
                    .signatureDuration(Duration.ofMinutes(expirationInMinutes))
                    .putObjectRequest(req -> req
                            .bucket(bucketName)
                            .key(objectKey)
                            .build())
                    .build();

            PresignedPutObjectRequest presignedRequest = s3Presigner.presignPutObject(presignRequest);
            
            return presignedRequest.url().toString();
        } catch (Exception e) {
            //log.error("Error generating pre-signed URL for upload: ", e);
            throw new RuntimeException("Failed to generate pre-signed URL for upload", e);
        }
    }
    
    public String generatePresignedUrlForDownload(String objectKey, long expirationInMinutes) {
        try {
            GetObjectPresignRequest presignRequest = GetObjectPresignRequest.builder()
                    .signatureDuration(Duration.ofMinutes(expirationInMinutes))
                    .getObjectRequest(req -> req
                            .bucket(bucketName)
                            .key(objectKey)
                            .build())
                    .build();

            PresignedGetObjectRequest presignedRequest = s3Presigner.presignGetObject(presignRequest);
            
            return presignedRequest.url().toString();
        } catch (Exception e) {
            //log.error("Error generating pre-signed URL for download: ", e);
            throw new RuntimeException("Failed to generate pre-signed URL for download", e);
        }
    }
    
    public boolean doesObjectExist(String objectKey) {
        try {
            HeadObjectRequest headObjectRequest = HeadObjectRequest.builder()
                    .bucket(bucketName)
                    .key(objectKey)
                    .build();

            s3Client.headObject(headObjectRequest);
            return true;
        } catch (NoSuchKeyException e) {
            return false;
        }
    }
}
