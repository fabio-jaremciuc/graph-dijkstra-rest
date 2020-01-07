package com.spring.graphexample.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ApiErrorHandler {

	public ResponseEntity<Object> handleApiError(ApiErrorCode apiErrorCode) {
		switch (apiErrorCode) {
		case VALIDATION_ERROR:
			return ResponseEntity.status(400).body(new ErrorDetail("Error", 400,"Bad Request - Information entered incorrectly"));
		case INTERNAL_SERVER_ERROR:
			return ResponseEntity.status(500).body(new ErrorDetail("Error", 500,"Bad Request - Internal server error"));
		case NOT_FOUND:
			return ResponseEntity.status(404).body(new ErrorDetail("Error", 404,"Not Found"));
		default:
			break;
		}
		return null;
	}
	
}
