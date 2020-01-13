package com.spring.graphexample.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CandidatesRankingTest {

	@Test
	final void test() {
		CandidatesRanking candidatesRanking = new CandidatesRanking();
		CandidateRanked candidateRanked = new CandidateRanked(1, "candidateLocation", 1, 50);
		List<CandidateRanked> candidateRankedList = new ArrayList<>();
		candidateRankedList.add(candidateRanked);
		candidatesRanking.setCandidatesRanking(candidateRankedList);
		assertNotNull(candidatesRanking);
	}

}
