package com.spring.graphexample.service;

import org.springframework.stereotype.Component;

@Component
public class GraphService {

	public int calcExpirenceLevel(int candidateExpLevel, int jobExpLevel) {
		int expirenceLevel = 100 - 25 * (jobExpLevel - candidateExpLevel);
		return expirenceLevel;
	}
	
	public int calcPathPoints(Double shortestPath) {
		if (shortestPath <= 5.0) {
			return 100;
		}
		if (5.0 < shortestPath && shortestPath <= 10.0) {
			return 75;
		}
		if (10.0 < shortestPath && shortestPath <= 15.0) {
			return 50;
		}
		if (15.0 < shortestPath && shortestPath <= 20.0) {
			return 25;
		}
		if (20.0 < shortestPath) {
			return 0;
		}
		return 0;
	}
	
	public int calcScoreCandidate(int experienceLevel, int pathPoints) {
		int scoreCandidate = (experienceLevel + pathPoints) / 2;
		return scoreCandidate;
	}
	
}
