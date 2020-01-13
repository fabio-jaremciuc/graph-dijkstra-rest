package com.spring.graphexample.exception;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ApiErrorHandler {

	public ResponseEntity<Object> handleSQLErrorException(Exception ex) {
		ErrorDetail errorBody = new ErrorDetail("Error", 404, 
				ex.getMessage());
		return ResponseEntity.status(404).body(errorBody);
		
	}
	
	public ResponseEntity<Object> handleApiParamError(List<String> missingParams) {
		ErrorDetail errorBody = new ErrorDetail("Error", 400, "The following required parameters are missing: " 
				+ missingParams);
		return ResponseEntity.status(400).body(errorBody);
		
	}
}
