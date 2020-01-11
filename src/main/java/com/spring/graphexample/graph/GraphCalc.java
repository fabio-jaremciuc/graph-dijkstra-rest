package com.spring.graphexample.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GraphCalc {
	
	public Double getShortestPath(NodeWeighted start, NodeWeighted stop) {

		// TODO: list to cicle and select the node of start and stop
		GraphWeighted graphWeighted = new GraphWeighted(true);
		NodeWeighted nodeA = new NodeWeighted("A");
		NodeWeighted nodeB = new NodeWeighted("B");
		NodeWeighted nodeC = new NodeWeighted("C");
		NodeWeighted nodeD = new NodeWeighted("D");
		NodeWeighted nodeE = new NodeWeighted("E");
		NodeWeighted nodeF = new NodeWeighted("F");
		NodeWeighted nodeG = new NodeWeighted("G");

		log.info("node: {}", start);
		
		// Our addEdge method automatically adds Nodes as well.
		// The addNode method is only there for unconnected Nodes,
		// if we wish to add any
		graphWeighted.addEdge(nodeA, nodeB, 8);
		graphWeighted.addEdge(nodeA, nodeC, 11);
		graphWeighted.addEdge(nodeB, nodeD, 3);
		graphWeighted.addEdge(nodeB, nodeE, 8);
		graphWeighted.addEdge(nodeB, nodeC, 7);
		graphWeighted.addEdge(nodeC, nodeE, 9);
		graphWeighted.addEdge(nodeD, nodeE, 5);
		graphWeighted.addEdge(nodeD, nodeF, 2);
		graphWeighted.addEdge(nodeE, nodeG, 6);
		graphWeighted.addEdge(nodeF, nodeE, 1);
		graphWeighted.addEdge(nodeF, nodeG, 8);

		List<NodeWeighted> nodeList = Arrays.asList(nodeA, nodeB, nodeC, nodeD, nodeE, nodeF, nodeG);
						
		// works
		graphWeighted.DijkstraShortestPath(start, stop);

		//doesnt work
		return graphWeighted.DijkstraShortestPath(nodeG, nodeG);
	}

}
