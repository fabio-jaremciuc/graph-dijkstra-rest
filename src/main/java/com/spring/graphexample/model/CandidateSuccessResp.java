package com.spring.graphexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateSuccessResp {

	private String status;
	private String message;
	private Candidate data;
	
	public CandidateSuccessResp candidateSuccess(Candidate candidate) {
		CandidateSuccessResp candidateSuccess = new CandidateSuccessResp("Success!", "New Entry!", candidate);
		return candidateSuccess;
	}
}