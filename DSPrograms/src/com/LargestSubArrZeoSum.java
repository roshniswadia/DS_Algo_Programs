package com;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrZeoSum {

	public static void main(String[] args) {
		int[] arr = { 7, 1, -1, 2, 6, -2, -6, 6, 8, -8, -6, 9 };

		int sum = 0;
		int max_length = 0;
		int max_array_start = 0;
		int max_array_end = 0;
		Map<Integer, Integer> sumIndexMap = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			if (sumIndexMap.containsKey(sum)) {

				max_length = (i - sumIndexMap.get(sum)) + 1;
				max_array_start = sumIndexMap.get(sum) + 1;
				max_array_end = i;
			} else {
				sumIndexMap.put(sum, i);
			}
		}

		System.out.println("Max Array Length : " + max_length);
		for (int i = max_array_start; i <= max_array_end; i++) {
			System.out.println(arr[i]);
		}

	}

}
