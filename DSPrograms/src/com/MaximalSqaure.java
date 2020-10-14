package com;

public class MaximalSqaure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// char M[][] =
		// {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};

		char M[][] = { { '1' } };
		int maximalSqaureSize = findMaximalSquare(M);
		System.out.println("Maximal Square Area : " + maximalSqaureSize * maximalSqaureSize);

	}

	public static int findMaximalSquare(char[][] matrix) {

		if (matrix.length == 0)
			return 0;

		if (matrix[0].length == 1)
			return Integer.parseInt(String.valueOf(matrix[0]));
		int rowCount = matrix.length;
		int columnCount = matrix[0].length;

		int[][] matrix1 = new int[rowCount][columnCount];

		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				matrix1[i][j] = Integer.parseInt(String.valueOf(matrix[i][j]));
			}
		}

		int[][] matrixNew = new int[rowCount][columnCount];
		int maximalSqaureArea = Integer.MIN_VALUE;

		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				if (i == 0 || j == 0) {
					matrixNew[i][j] = matrix1[i][j];
					maximalSqaureArea = Math.max(maximalSqaureArea, matrixNew[i][j]);
				} else {
					if (matrix1[i][j] == 0) {
						matrixNew[i][j] = 0;
						maximalSqaureArea = Math.max(maximalSqaureArea, matrixNew[i][j]);
					} else {
						matrixNew[i][j] = Math.min(matrixNew[i - 1][j - 1],
								Math.min(matrixNew[i][j - 1], matrixNew[i - 1][j])) + 1;
						maximalSqaureArea = Math.max(maximalSqaureArea, matrixNew[i][j]);
					}
				}
			}
		}

		return maximalSqaureArea;
	}

}
