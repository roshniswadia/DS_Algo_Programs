package com;

import java.util.List;

/*Given a matrix of M x N elements (M rows, N columns), Print all elements of the 
matrix in diagonal order in Time Complexity O(m*n) and Space Complexity O(1)*/
public class PrintDiagonalMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matrix = {
	            { 1, 2, 3, 4 },     { 5, 6, 7, 8 },
	            { 9, 10, 11, 12 },  { 13, 14, 15, 16 },
	            { 17, 18, 19, 20 },
	        };
		
		printDiagnalElements(matrix);
	}
	
	public static void printDiagnalElements(int[][] matrix) {
		
		int rowLength = matrix.length;
		int columnLength = matrix[0].length;
		for(int k=0 ; k<rowLength; k++) {
			int j = 0;
			int i = k;
			while(i >= 0 && j< columnLength) {
				System.out.print(matrix[i][j] + " ");
				i=i-1;
				j=j+1;
			}
			System.out.println("");
		}
		
		for(int k = 1; k <columnLength; k++ ) {
			int i = rowLength - 1;
			int j = k;
			while(j<columnLength) {
				System.out.print(matrix[i][j] + " ");
				i=i-1;
				j=j+1;
			}
			System.out.println("");
		}
	}

}
