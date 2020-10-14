package com;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int[][] matrix2 = {{1,11},{2,12},{3,13},{4,14},{5,15},{6,16},{7,17},{8,18},{9,19},{10,20}};
		List<Integer> list = convertToSpiralMatrics(matrix2);
		System.out.println(list);
	}

	public static List<Integer> convertToSpiralMatrics(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		int rowLength = matrix.length -1;
		int columnLength = matrix[0].length -1;

		int currRow = 0;
		int currColumn = 0;

		while (currRow <= rowLength && currColumn <= columnLength) {
			for (int i = currColumn; i <= columnLength; i++) {
				list.add(matrix[currRow][i]);
			}
			currRow++;// 1

			for (int i = currRow; i <= rowLength; i++) {
				list.add(matrix[i][columnLength]);
			}
			columnLength--;// 2

			if (currColumn < columnLength) {
				for (int i = columnLength; i >= currColumn; i--) {
					list.add(matrix[rowLength][i]);
				}
				rowLength--;// 2
			}

			if (currRow < rowLength) {
				for (int i = rowLength; i >= currRow; i--) {
					list.add(matrix[i][currColumn]);
				}
				currColumn++;// 1
			}
		}

		return list;
	}

}
