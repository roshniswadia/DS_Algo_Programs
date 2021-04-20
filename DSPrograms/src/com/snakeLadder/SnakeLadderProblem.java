package com.snakeLadder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class SnakeLadderProblem {

	public static void main(String[] args) {
		int[][] inputArr = { { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 },
				{ -1, 35, -1, -1, 13, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, 15, -1, -1, -1, -1 } };
		findShortestDistance(inputArr);
	}

	static class QueueEntry {
		int vertex;
		int distanceFromStart;

		public QueueEntry(int vertex, int dist) {
			// TODO Auto-generated constructor stub
			this.vertex = vertex;
			this.distanceFromStart = dist;
		}

		public QueueEntry() {
			// TODO Auto-generated constructor stub
		}
	}

	static void findShortestDistance(int[][] gameboard) {

		int totalRow = gameboard.length;
		int totalColumn = gameboard[0].length;
		int boardSize = totalColumn * totalRow;
		int boardList[] = new int[boardSize];

		boolean moveLeftToRight = true;
		int count = 0;
		int listCount = 0;
		for (int i = totalRow -1; i >= 0; i--) {
			for(int j=0; j<=totalColumn-1; j++) {
			if(moveLeftToRight) {
				boardList[listCount] = gameboard[i][count];
				if(count == totalColumn -1)
					moveLeftToRight = false;
					else
				count++;
			}else {
				boardList[listCount] = gameboard[i][count];
				if(count == 0)
					moveLeftToRight = true;
				else
				count--;
			}
			
			listCount++;
			}
		}

		boolean[] isVisited = new boolean[boardSize];
		Queue<QueueEntry> queue = new ArrayDeque<>();
		queue.add(new QueueEntry(0, 0));
		isVisited[0] = true;

		while (!queue.isEmpty()) {
			QueueEntry currentEntry = queue.poll();
			int currentVertex = currentEntry.vertex;
			if (currentEntry.vertex == boardSize - 1) {
				System.out.println("Least Number of roll : " + currentEntry.distanceFromStart);
				break;
			}
			for (int k = currentVertex + 1; k <= currentVertex + 6 && k < boardSize; k++) {
				if (!isVisited[k]) {
					QueueEntry newentry = new QueueEntry();
					
					if (boardList[k] != -1) {
						newentry.vertex = boardList[k] -1;
					} else {
						newentry.vertex = k;
					}
					isVisited[k] = true;
					newentry.distanceFromStart = currentEntry.distanceFromStart + 1;
					queue.add(newentry);
				}
			}
		}
	}
}
