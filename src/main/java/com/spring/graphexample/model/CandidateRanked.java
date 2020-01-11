package com.spring.graphexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateRanked {

	private int candidateId;
	private String candidateLocation;
	private int candidateLevel;
	private int candidateScore;
	
	
}
