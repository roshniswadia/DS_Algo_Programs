package com;

/*Array of length n having integers 1 to n with some elements being repeated. 
Count frequencies of all elements from 1 to n in Time Complexity O(n) and Space Complexity O(1)*/
public class CountFreqOfElements {

	public static void main(String[] args) {
		int[] arr = { 5, 2, 7, 7, 5, 5, 2 };

		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] - 1;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > arr.length - 1) {
				int index = arr[i]%arr.length;
				arr[index] = arr[index] + arr.length;
			} else {
				int index = arr[i];
				arr[index] = arr[index] + arr.length;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if(arr[i] > arr.length) {
				int index = arr[i]/arr.length;
				System.out.println("freq of number " + i + " is " + index);
			}
		}
	}

}
