package com.spring.graphexample.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class CandidateTest {

	@Test
	final void test() {
		Candidate candidate = new Candidate(1, "candidateName", "candidateOccupation",
				"candidateLocation", 2, "candidateAppPosition");
		
		assertEquals(1, candidate.getCandidateId());
		assertEquals("candidateName", candidate.getCandidateName());
		assertEquals("candidateOccupation", candidate.getCandidateOccupation());
		assertEquals("candidateLocation", candidate.getCandidateLocation());
		assertEquals(2, candidate.getCandidateLevel());
		assertEquals("candidateAppPosition", candidate.getCandidateAppPosition());
		assertNotNull(candidate);
		
	}

}
