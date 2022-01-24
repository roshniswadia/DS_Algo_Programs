package com;

import java.util.Arrays;

public class CandyDistributionProblem {
	/*
	 * There are N children standing in a line with some rating value. You want to
	 * distribute a minimum number of candies to these children such that:
	 * 
	 * Each child must have at least one candy. The children with higher ratings
	 * will have more candies than their neighbors. You need to write a program to
	 * calculate the minimum candies you must give.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {0, 4, 9, 25, 8, 6, 5};
		
		int left[] = new int[arr.length];
		int right[] = new int[arr.length];
		Arrays.fill(left, 1);
		Arrays.fill(right, 1);
		
		for(int i=0; i<left.length -1; i++) {
			if(arr[i+1] > arr[i]) {
				left[i+1] = left[i] + 1; 
			}
		}
		
		int minCandy = 0;
		for(int i=right.length - 1; i>0; i--) {
			if(arr[i-1] > arr[i]) {
				right[i-1] = right[i] + 1;
			}
		}
		
		for(int i=0; i<=left.length -1; i++) {
			right[i] = Math.max(left[i], right[i]);
			minCandy = minCandy + right[i];
		}
		
		
		System.out.println("Minimum Candy : " + minCandy);
		
	}

}
