package com.spring.graphexample.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JobCandidateScore {

	private String status;
	private String message;
	private JobVacancy jobVacancy;
	private Candidate candidate;
	private int score;
	
}
