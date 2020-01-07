package com.spring.graphexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Candidate {

	private String candidateName;
	private String candidateOccupation;
	private String candidateLocation;
	private Integer candidateLevel;
	private String candidateAppPosition;
	
}
