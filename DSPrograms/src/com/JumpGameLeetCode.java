package com;

public class JumpGameLeetCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr1 = {3,2,1,0,4};
		int[] arr2 = {2,3,1,1,4};
		
		System.out.println("Can reach array end : " + canReachEnd(arr1));
		
		System.out.println("Can reach array 2 end : " + canReachEnd(arr2));

	}
	
	public static boolean canReachEnd(int[] arr) {
		int lastGoodPos = arr.length - 1;
		for(int i = arr.length - 1; i>= 0 ;i--) {
			if(i + arr[i] >= lastGoodPos) {
				lastGoodPos = i;
			}
		}
		return lastGoodPos == 0;
	}

}
