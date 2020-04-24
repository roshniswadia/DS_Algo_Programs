package com;

public class QuickSortDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 10, 7, 8, 9, 1, 5 };
		
		quickSort(arr, 0, arr.length -1);
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

	public static void quickSort(int arr[], int start, int end) {
		if (start < end) {
			int partition = partition(arr, start, end);
			quickSort(arr, start, partition - 1);
			quickSort(arr, partition + 1, end);
		}
	}

	public static int partition(int arr[], int start, int end) {
		int pivot = arr[end];
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (arr[j] < pivot && i != j) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = pivot;
		arr[end] = temp;

		return i + 1;

	}
}
