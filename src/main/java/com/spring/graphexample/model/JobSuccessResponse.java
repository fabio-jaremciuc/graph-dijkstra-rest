package com.spring.graphexample.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JobSuccessResponse {

	private String status;
	private String message;
	private JobVacancy data;
	
}
