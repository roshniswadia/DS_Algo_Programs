package com;

import java.util.Vector;

public class KnightChessBoardHacker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Min Steps : " + minMoves(9, 4, 4, 4, 8));
	}

	static class cell {
		int x, y;
		int dis;

		public cell(int x, int y, int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
	}

	static boolean isInsideBoard(int x, int y, int N) {
		if (x >= 0 && x <= N -1 && y >= 0 && y <= N -1)
			return true;
		return false;
	}

	public static int minMoves(int n, int startRow, int startCol, int endRow, int endCol) {
		int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
		int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };

		// queue for storing states of knight in board
		Vector<cell> q = new Vector<>();

		// push starting position of knight with 0 distance
		q.add(new cell(startRow, startCol, 0));

		cell t;
		int x, y;
		boolean visit[][] = new boolean[n + 1][n + 1];

		// make all cell unvisited
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				visit[i][j] = false;

		// visit starting state
		visit[startRow][startCol] = true;

		// loop untill we have one element in queue
		while (!q.isEmpty()) {
			t = q.firstElement();
			q.remove(0);

			// if current cell is equal to target cell,
			// return its distance
			if (t.x == endRow && t.y == endCol)
				return t.dis;

			// loop for all reachable states
			for (int i = 0; i < 8; i++) {
				x = t.x + dx[i];
				y = t.y + dy[i];

				// If reachable state is not yet visited and
				// inside board, push that state into queue
				if (isInsideBoard(x, y, n) && !visit[x][y]) {
					visit[x][y] = true;
					q.add(new cell(x, y, t.dis + 1));
				}
			}
		}
		return -1;
	}

}
