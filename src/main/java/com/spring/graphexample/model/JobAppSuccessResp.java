package com.spring.graphexample.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JobAppSuccessResp {

	private String status;
	private String message;
	private JobVacancy jobVacancy;
	private Candidate candidate;
	private Integer score;
	
}
