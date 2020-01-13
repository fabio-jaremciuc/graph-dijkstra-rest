package com.spring.graphexample.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class CandidateSuccessRespTest {

	@Test
	final void test() {
		Candidate candidate = new Candidate(1, "candidateName", "candidateOccupation",
				"candidateLocation", 2, "candidateAppPosition");
	
		CandidateSuccessResp candidateSuccessResp = new CandidateSuccessResp("Success", "OK", candidate);
		
		assertEquals("Success", candidateSuccessResp.getStatus());
		assertEquals("OK", candidateSuccessResp.getMessage());
		assertEquals(candidate.getCandidateName(), candidateSuccessResp.getData().getCandidateName());
		assertNotNull(candidateSuccessResp);
		
	}

}
