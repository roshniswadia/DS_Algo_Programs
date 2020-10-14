package com;

public class ArraySortLessThanGreatorThan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 1, 4, 5, 9, 10, 12 }; // 1 <5 >4 <10 >9 <12
		int counter = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			counter = i + 1;
			if (i % 2 == 0) {
				if (arr[i] > arr[counter]) {
					while (counter < arr.length && arr[i] < arr[counter]) {
						counter++;
					}
					int temp = arr[i];
					arr[i] = arr[counter];
					arr[counter] = temp;
				}
			} else {
				if (arr[i] < arr[counter]) {
					while (counter < arr.length && arr[i] > arr[counter]) {
						counter++;
					}
					int temp = arr[i];
					arr[i] = arr[counter];
					arr[counter] = temp;
				}
			}

		}

		System.out.println(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

}
