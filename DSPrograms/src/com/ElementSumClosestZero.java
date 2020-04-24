package com;

import java.util.Arrays;

public class ElementSumClosestZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 1, 60, -10, 70, -80, 85 }; // -80, -10, 1, 60, 75, 85
		Arrays.sort(arr);
		int min_sum = Integer.MAX_VALUE;
		int min_l = 0;
		int min_r = 0;

		int l = 0;
		int r = arr.length - 1;

		while (l < r) {
			int sum = arr[l] + arr[r];
			if (Math.abs(sum) < Math.abs(min_sum)) {
				min_sum = sum;
				min_l = l;
				min_r = r;
			}

			if (sum > 0)
				l++;
			else
				r--;

		}

		System.out.println("Two elemsnts with sum closest to zero : " + arr[min_l] + " and " + arr[min_r]);

	}

}
