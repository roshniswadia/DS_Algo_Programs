package com;

import java.util.HashMap;
import java.util.Map;

public class MinJumps {

	static Map<Integer, Integer> jumpsMap = new HashMap<>();

	public static void main(String[] args) {
		int arr1[] = { 2, 4, 1, 1, 3, 2, 6, 8, 2, 9, 3, 2, 1, 4, 1, 1, 1, 3, 3, 6 };
		
		int arr2[] = {3,2,1,0,4};
		int minJumps = findJumps(arr2, 0);
		if(minJumps == Integer.MAX_VALUE)
			System.out.println("True");
		else
			System.out.println("False");
		System.out.println(minJumps);
	}

	public static int findJumps(int array1[], int start) {
		if (start == array1.length - 1)
			return 0;

		int remainingArrayLength = array1.length - start;

		if (array1[start] == 0)
			return Integer.MAX_VALUE;

		if (jumpsMap.containsKey(start))
			return jumpsMap.get(start);

		if (array1[start] >= remainingArrayLength)
			return 1;

		int minimumJumps = Integer.MAX_VALUE;
		for (int i = 1; i <= array1[start]; i++) {
			int jumps = findJumps(array1, start + i);
			if (jumps != Integer.MAX_VALUE) {
				minimumJumps = Math.min(minimumJumps, jumps + 1);
			}
		}
		jumpsMap.put(start, minimumJumps);
		return minimumJumps;
	}
}
