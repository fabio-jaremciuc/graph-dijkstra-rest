package com.spring.graphexample.graph;

import java.util.LinkedList;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NodeWeighted {
	// The int n and String name are just arbitrary attributes
	// we've chosen for our nodes these attributes can of course
	// be whatever you need
	String name;
	boolean visited;
	LinkedList<EdgeWeighted> edges;

	public NodeWeighted(String name) {
		this.name = name;
		visited = false;
		edges = new LinkedList<>();
	}

	boolean isVisited() {
		return visited;
	}

	void visit() {
		visited = true;
	}

	void unvisit() {
		visited = false;
	}
}
