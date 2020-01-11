package com.spring.graphexample.service;

public class GraphService {

	public int calcExpirenceLevel(int candidateExpLevel, int jobExpLevel) {
		int expirenceLevel = 100 - 25 * (jobExpLevel - candidateExpLevel);
		return expirenceLevel;
	}
	
	public int calcScoreCandidate(int experienceLevel, double shortestPath) {
		int scoreCandidate = (experienceLevel + (int) shortestPath) / 2;
		return scoreCandidate;
	}
	
}
