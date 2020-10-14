package com;

public class LargestContSubArray {

	public static void main(String[] args) {
		int arr1[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

		int meh = arr1[0]; // 0 =-2, 1, -2, 4, 3, 5, 6, 1, 5
		int msf = arr1[0]; // -2, 1, 4, 6

		int currentStart = 0, maxStart = 0, maxEnd = 0;

		for (int i = 1; i < arr1.length - 1; i++) {
			if ((arr1[i] + meh) > arr1[i]) {
				meh = arr1[i] + meh;
			} else {
				meh = arr1[i];
				currentStart = i;
			}

			if (meh > msf) {
				msf = meh;
				maxStart = currentStart;
				maxEnd = i;
			}
		}

		System.out.println("Contiguous Array with Max Sum : ");
		for (int i = maxStart; i <= maxEnd; i++) {
			System.out.println(arr1[i]);
		}

		System.out.println("Max Sum : " + msf);
	}

}
