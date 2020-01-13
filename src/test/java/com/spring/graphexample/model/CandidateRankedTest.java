package com.spring.graphexample.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class CandidateRankedTest {

	@Test
	final void test() {
		CandidateRanked candidateRanked = new CandidateRanked(1, "candidateLocation", 1, 50);
		
		assertEquals(1, candidateRanked.getCandidateId());
		assertEquals("candidateLocation", candidateRanked.getCandidateLocation());
		assertEquals(1, candidateRanked.getCandidateLevel());
		assertEquals(50, candidateRanked.getCandidateScore());
		assertNotNull(candidateRanked);
	}

}
