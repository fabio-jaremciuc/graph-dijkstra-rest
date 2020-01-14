package com.spring.graphexample.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GraphCalcTest {

	@Test
	final void test() {
		
		GraphCalc graphCalc = new GraphCalc();
		NodeWeighted start = new NodeWeighted("A");
		NodeWeighted stop = new NodeWeighted("G");
		
		Double shortestPath = graphCalc.getShortestPath(start, stop);

		assertEquals(20.0, shortestPath);
	}

}
