package com.spring.graphexample.graph;

import java.util.LinkedList;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NodeWeighted {
	private String name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
