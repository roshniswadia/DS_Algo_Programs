package com;

public class MergeSortProgram {

	public static void main(String[] args) {

		int[] arr1 = { 10, 45, 5, 2, 5, 1, 7, 8, 19, 9, 2 };
		int mid = arr1.length / 2;
		int start = 0;
		int end = arr1.length - 1;

		mergeSort(arr1, start, end);
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}

	}

	public static void mergeSort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
	}

	public static void merge(int[] arr, int start, int mid, int end) {

		int firstArrayLength = mid - start + 1;
		int secondArrayLength = end - mid;

		int[] firstArray = new int[firstArrayLength];
		int[] secondArray = new int[secondArrayLength];

		for (int i = 0; i < firstArrayLength; i++) {
			firstArray[i] = arr[start + i];
		}

		for (int i = 0; i < secondArrayLength; i++) {
			secondArray[i] = arr[mid + 1 + i];
		}

		int i = 0;
		int j = 0;
		int k = start;

		while (i < firstArrayLength && j < secondArrayLength) {
			if (firstArray[i] > secondArray[j]) {
				arr[k] = secondArray[j];
				j++;
			} else {
				arr[k] = firstArray[i];
				i++;
			}
			k++;
		}

		while (i < firstArrayLength) {
			arr[k] = firstArray[i];
			i++;
			k++;
		}

		while (j < secondArrayLength) {
			arr[k] = secondArray[j];
			j++;
			k++;
		}
	}

}
