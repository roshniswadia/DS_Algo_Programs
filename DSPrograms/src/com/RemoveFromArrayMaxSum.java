package com;

import java.util.HashMap;
import java.util.Map;

public class RemoveFromArrayMaxSum {

	public static void main(String[] args) {
		int arr[] = { 1, 1, 3, 3, 2, 2, 1, 1, 1 };

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];

			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}

		int minimum = Integer.MAX_VALUE;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			minimum = Math.min(minimum, entry.getKey() * entry.getValue());
		}

		System.out.println("Maximum Sum : " + (sum - minimum));

	}

}
