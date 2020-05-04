package com;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayPairWithGivenSum {

	public static void main(String[] args) {

		int[] arr = { 0, -1, 2, -3, 1, -1 };
		int sum = -2;

		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			int temp = sum - arr[i];

			if (set.contains(temp)) {
				System.out.println("Pair " + arr[i] + " : " + temp);
			} else {
				set.add(arr[i]);
			}
		}
		
		SolutionTwo(arr);

	}

	public static void SolutionTwo(int[] arr) {
			
			int start = 0;
			int end = arr.length - 1;
			int sum = -2;
			
			Arrays.sort(arr);
			
			while(start < end) {
				if(arr[start] + arr[end] == sum) {
					System.out.println("Pair " + arr[start] + " : " + arr[end]);
					start++;
				}else if(arr[start] + arr[end] > sum) {
					end--;
				}else {
					start++;
				}
			}
		}

}
