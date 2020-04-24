package com;

public class MergeSortOneArr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr1 = { 10, 45, 5, 2, 5, 1, 7, 8, 19, 9, 2 };
		int mid = arr1.length / 2;
		int start = 0;
		int end = arr1.length - 1;

		mergeSort(arr1, start, end);
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}

	}

}
