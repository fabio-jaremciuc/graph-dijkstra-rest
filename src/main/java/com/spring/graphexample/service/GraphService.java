package com.spring.graphexample.service;

import org.springframework.stereotype.Component;

@Component
public class GraphService {

	public int calcExpirenceLevel(int candidateExpLevel, int jobExpLevel) {
		int expirenceLevel = 100 - 25 * (jobExpLevel - candidateExpLevel);
		return expirenceLevel;
	}
	
	public int calcPathPoints(Double shortestPath) {
		if (shortestPath <= 6.0) {
			return 100;
		}
		if (6.0 < shortestPath && shortestPath <= 8.75) {
			return 75;
		}
		if (8.75 < shortestPath && shortestPath <= 13.75) {
			return 50;
		}
		if (13.75 < shortestPath && shortestPath <= 18.75) {
			return 25;
		}
		if (18.75 < shortestPath) {
			return 0;
		}
		return 0;
	}
	
	public int calcScoreCandidate(int experienceLevel, int pathPoints) {
		int scoreCandidate = (experienceLevel + pathPoints) / 2;
		return scoreCandidate;
	}
	
}
