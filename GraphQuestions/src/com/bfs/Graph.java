package com.bfs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Graph {

	public int V;;
	public LinkedList<Integer> adjacencyList[];

	public Graph(int v) {
		this.V = v;
		adjacencyList = new LinkedList[v + 1];
		for (int i = 1; i <= v; i++) {
			adjacencyList[i] = new LinkedList<>();
		}
	}

	void addEdge(int v, int w) {
		adjacencyList[v].add(w);
	}

	void bfsTraversal(int source) {
		boolean[] isVisited = new boolean[V + 1];
		LinkedList<Integer> queue = new LinkedList<>();

		queue.add(source);
		isVisited[source] = true;

		while (!queue.isEmpty()) {
			int vertex = queue.poll();
			System.out.println(vertex);

			Iterator<Integer> itr = adjacencyList[vertex].iterator();
			while (itr.hasNext()) {
				int n = itr.next();

				if (!isVisited[n]) {
					queue.add(n);
					isVisited[n] = true;
				}
			}
		}
	}

	void dfsTraversal(int source) {
		boolean[] isVisited = new boolean[V];

		dfsUtil(isVisited, source);
	}

	void dfsUtil(boolean[] isVisited, int v) {

		isVisited[v] = true;
		System.out.println(v);

		Iterator<Integer> list = adjacencyList[v].listIterator();
		while (list.hasNext()) {
			int n = list.next();
			if (!isVisited[v]) {
				dfsUtil(isVisited, v);

			}

		}
	}

	public static void main(String[] args) {
		Graph grp = new Graph(6);
		grp.addEdge(1, 2);
		grp.addEdge(1, 3);
		grp.addEdge(2, 4);
		grp.addEdge(2, 5);
		grp.addEdge(3, 5);
		grp.addEdge(4, 6);
		grp.addEdge(4, 5);
		grp.addEdge(5, 6);
		grp.dfsTraversal(1);
	}
}
