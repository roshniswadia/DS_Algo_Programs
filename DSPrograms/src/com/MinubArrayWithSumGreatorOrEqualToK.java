package com;

public class MinubArrayWithSumGreatorOrEqualToK {

	public static void main(String[] args) {
		int minsum = 11;
		int[] arr = {7,2,1,1,6,5};

		int start = 0;
		int sum = 0;
		int min_length = Integer.MAX_VALUE;
		
		for(int end = 0 ; end<arr.length ; end++) {
			sum  = sum + arr[end];
			
			while(sum>=minsum && start <= end) {
				min_length = Math.min(min_length, end - start + 1);
				sum = sum - arr[start++];
			}
		}
		
		System.out.println("Min length : " + min_length);
	}

}
