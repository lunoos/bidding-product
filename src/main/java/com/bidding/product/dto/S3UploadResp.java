package com.bidding.product.dto;

public class S3UploadResp {
	
	private String postURl;
	private String objectKey;
	public String getPostURl() {
		return postURl;
	}
	public void setPostURl(String postURl) {
		this.postURl = postURl;
	}
	public String getObjectKey() {
		return objectKey;
	}
	public void setObjectKey(String objectKey) {
		this.objectKey = objectKey;
	}
	
	public S3UploadResp(String postURl, String objectKey) {
		super();
		this.postURl = postURl;
		this.objectKey = objectKey;
	}
	@Override
	public String toString() {
		return "S3UploadResp [postURl=" + postURl + ", objectKey=" + objectKey + "]";
	}
	
	
}
